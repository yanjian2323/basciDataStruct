public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }
    public ArrayStack(){
        this(10);
    }
    public int getCapacity() {
        return array.getCapacity();
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
    // 入栈
    public void push(E e) {
        array.addLast(e);
    }
    @Override
    // 出栈
    public E pop() {
        return array.removeLast();
    }
    @Override
    // 取栈顶元素
    public E peek() {
        return array.getLast();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < getSize(); i++) {
            sb.append(array.get(i));
            if (i != getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("]pop");
        return sb.toString();
    }
}
