// 基于动态数组的队列实现
public class ArrayQueue<E> implements queue<E> {
    private Array<E> array;
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }
    public ArrayQueue() {
        this(10);
    }
    @Override
    public int getSize() {
        return array.getSize();
    }
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }
    @Override
    // O(n)的复杂度,用循环队列可以改成O(1)的复杂度
    public E dequeue() {
        return array.removeFirst();
    }
    @Override
    public E getFront() {
        return array.getFirst();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("first[");
        for (int i = 0; i < getSize(); i++) {
            sb.append(array.get(i));
            if (i < getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("]end");
        return sb.toString();
    }
}
