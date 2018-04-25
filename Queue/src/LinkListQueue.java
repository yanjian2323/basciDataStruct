// 基于链表的队列实现
public class LinkListQueue<E> implements queue<E> {
    private class Node {
        public E val;
        public Node next;
        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }
        public Node(E val) {
            this(val, null);
        }
        public Node() {
            this(null, null);
        }
    }
    private int size;//队列元素个数
    private Node head;//队首
    private Node tail;//队尾

    public LinkListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        Node newNode = new Node(e);
        if (tail != null) tail.next = newNode;
        tail = newNode;
        if (head == null) head = tail;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue tail,deqeue is empty");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.val;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue tail,deqeue is empty");
        }
        return head.val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("top[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.val);
            if (cur != tail) {
                sb.append("->");
            }
            cur = cur.next;
        }
        sb.append("]bottom");
        return sb.toString();
    }
}
