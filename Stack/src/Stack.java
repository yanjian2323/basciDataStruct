public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();//弹出栈顶元素
    E peek();//取栈顶元素,不弹出
}
