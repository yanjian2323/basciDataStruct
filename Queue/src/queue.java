// 队列的基本接口
public interface queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);//入队
    E dequeue();//出队
    E getFront();//得到队首元素
}
