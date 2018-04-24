// 循环队列
public class LoopQueue<E> implements queue<E> {
    private E[] data;
    private int front;// 循环队列第一个元素索引
    private int tail;// 循环队列最后一个元素的下一个索引
    private int size;// 循环队列里元素个数
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity+1];
//        for(int i = 0; i < size; i++) {
//            newData[i] = data[(i + front) % data.length];
//        }
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            newData[(i - front) % data.length] = data[i % data.length];
        }
        // 注意要恢复一下初始值
        front = 0;
        tail = size;
        data = newData;
    }
    public LoopQueue(int capacity){
        // 有一个位置是浪费的，所以是capacity+1
        data = (E[])new Object[capacity+1];
        size = 0;
        front = 0;
        tail = 0;
    }
    public LoopQueue() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity () {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        // 队列已经满了,需要扩容
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    // 出队是O(1)的复杂度
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue fail,queue is empty");
        }
        E ret = data[front];
        front = (front + 1) % data.length;
        size--;
        if (size == data.length / 4 && data.length != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("getFront fail,queue is empty");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("size = %d, capacity = %d,", size, getCapacity()));
        sb.append("first[");
        for(int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(",");
            }
        }
        sb.append("]end");

        return sb.toString();
    }
}
