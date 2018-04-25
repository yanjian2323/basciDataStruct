// 基于链表的栈实现
public class LinkListStack<E> implements Stack<E> {
    private LinkList<E> linklist;
    public LinkListStack() {
        linklist = new LinkList<>();
    }

    @Override
    public int getSize() {
        return linklist.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linklist.isEmpty();
    }

    @Override
    public void push(E e) {
        linklist.addFirst(e);
    }

    @Override
    public E pop() {
        return linklist.removeFirst();
    }

    @Override
    public E peek() {
        return linklist.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("top[");
        for (int i = 0; i < linklist.getSize(); i++) {
            sb.append(linklist.get(i));
            if (i < linklist.getSize() - 1) {
                sb.append("->");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
