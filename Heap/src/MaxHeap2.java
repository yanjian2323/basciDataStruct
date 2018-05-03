// 最大堆
public class MaxHeap2<E extends Comparable<E>> {
    private E[] data;
    private int count;

    // 父节点索引
    private int parenIndex(int i) {
        return i / 2;
    }

    // 左节点索引
    private int leftIndex(int i) {
        return 2 * i;
    }

    // 右节点索引
    private int rightIndex(int i) {
        return 2 * i + 1;
    }

    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void shiftUp(int k) {
        while (k > 1 && data[k].compareTo(data[parenIndex(k)]) > 0) {
            swap(k, parenIndex(k));
            k = parenIndex(k);
        }
    }

    private void shiftDown(int k) {
        // 还有左节点就一直循环
        while(leftIndex(k) <= count) {
            int j = leftIndex(k);
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j = j + 1;
            }
            if (data[k].compareTo(data[j]) >= 0) break;
            swap(k, j);
            k = j;
        }
    }

    public MaxHeap2(int capacity) {
        // 下标从1开始,所以开辟capacity+1个空间
        data = (E[])new Object[capacity + 1];
        count = 0;
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // 像堆中添加元素
    public void add(E e) {
        if (count == data.length) {
            throw new IllegalArgumentException("add fail,data is full");
        }
        count++;
        data[count] = e;
        shiftUp(count);
    }

    // 查看最大元素(不删除)
    public E findMax() {
        if (count == 0) {
            throw new IllegalArgumentException("findMax fail,data is empty");
        }
        return data[1];
    }

    // 取出最大元素
    public E extractMax() {
        E max = findMax();
        swap(0, count);
        count--;
        shiftDown(0);

        return max;
    }
}
