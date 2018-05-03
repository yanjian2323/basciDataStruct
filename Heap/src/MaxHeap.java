// 基于动态数组Array实现的MaxHeap
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    // 父节点索引
    private int parenIndex(int i) {
        return (i - 1) / 2;
    }

    // 左节点索引
    private int leftIndex(int i) {
        return 2 * i + 1;
    }

    // 右节点索引
    private int rightIndex(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private void shiftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parenIndex(k))) > 0) {
            swap(k, parenIndex(k));
            k = parenIndex(k);
        }
    }

    private void shiftDown(int k) {
        // 还有左节点就一直循环
        while(leftIndex(k) <= data.getSize() - 1) {
            int j = leftIndex(k);
            if (j + 1 <= data.getSize() - 1 && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = j + 1;
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) break;
            swap(k, j);
            k = j;
        }
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // 把一个数组转为最大堆
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        // heapify，复杂度是O(n),复杂度的推导比较麻烦
        for (int i = (data.getSize() - 1) / 2; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 像堆中添加元素
    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    // 查看最大元素(不删除)
    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("findMax fail,data is empty");
        }
        return data.get(0);
    }

    // 取出最大元素
    public E extractMax() {
        E max = findMax();
        swap(0, data.getSize() - 1);
        data.removeLast();
        shiftDown(0);

        return max;
    }

    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        shiftDown(0);

        return ret;
    }
}
