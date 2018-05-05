// 线段树
public class SegmentTree<E> {
    private E[] data;// 区间的数据
    private E[] treeData;// 区间数据的二叉树结构,每个元素存储一个区间的值
    private Merger<E> merger;

    private int getLeftIndex(int i) {
        return 2 * i + 1;
    }

    private int getRightIndex(int i) {
        return 2 * i + 2;
    }

    // 构建一个线段树
    private E buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            return data[l];
        }
        int leftIndex = getLeftIndex(treeIndex);
        int rightIndex = getRightIndex(treeIndex);
        int mid = l + (r - l) / 2;
        treeData[leftIndex] = buildSegmentTree(leftIndex, l, mid);
        treeData[rightIndex] = buildSegmentTree(rightIndex,mid + 1, r);
        treeData[treeIndex] = merger.merge(treeData[leftIndex], treeData[rightIndex]);

        return treeData[treeIndex];
    }
    // 查询某个区间的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return treeData[treeIndex];
        }
        int mid = l + (r - l) / 2;
        if (queryL >= mid + 1) {
            return query(getRightIndex(treeIndex), mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(getLeftIndex(treeIndex), l, mid, queryL, queryR);
        } else {// 区间分布在左右两侧
            E leftData = query(getLeftIndex(treeIndex), l, mid, queryL, mid);
            E rightData = query(getRightIndex(treeIndex), mid + 1, r, mid + 1, queryR);

            return merger.merge(leftData, rightData);
        }
    }

    // 修改区间内的某个值
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            treeData[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftIndex = getLeftIndex(treeIndex);
        int rightIndex = getRightIndex(treeIndex);
        if (index <= mid) {
            set(leftIndex, l, mid, index, e);
        } else {
            set(rightIndex, mid + 1, r, index, e);
        }
        treeData[treeIndex] = merger.merge(treeData[leftIndex], treeData[rightIndex]);
    }


    public SegmentTree(E[] arr, Merger<E> merger) {

        data = (E[])new Object[arr.length];
        for(int i = 0; i < data.length; i++) {
            data[i] = arr[i];
        }
        // 开辟4*arr.length的空间，具体的分析可以查看remark文件
        treeData = (E[])new Object[4 * arr.length];
        this.merger = merger;
        buildSegmentTree(0, 0, data.length - 1);
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("query index is illegal");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw  new IllegalArgumentException("index is illegal");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < treeData.length; i++) {
            if (treeData[i] != null) {
                sb.append(treeData[i]);
            } else {
                sb.append("null");
            }
            if(i < treeData.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
