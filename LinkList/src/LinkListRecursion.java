// 用递归的方式来实现链表的增、删、改、查,因为链表和树结构一样具有天然的递归结构

public class LinkListRecursion<E>  {
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
    private int size;
    private Node dummyHead;// 虚拟头节点

    private void add(Node head, int targetIndex, int curIndex, E val) {
        if (curIndex == targetIndex) {
            head.next = new Node(val, head.next);
            size++;
            return;
        }
        add(head.next, targetIndex, curIndex + 1, val);
    }

    // 根据索引找到相应的节点
    private Node findNode(Node head, int targetIndex, int curIndex) {
        if (targetIndex == curIndex) {
            return head;
        }
        return findNode(head.next, targetIndex, curIndex + 1);
    }

    // 根据节点的值是否存在
    private boolean contains(Node head, E val) {
        if (head == null) {
            return false;
        }
        if (head.val == val) {
            return true;
        }
        return contains(head.next, val);
    }

    // remove
    private E remove(Node prev, int targetIndex, int curIndex) {
        if (curIndex == targetIndex) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.val;
        }
        return remove(prev.next, targetIndex, curIndex + 1);
    }

    public LinkListRecursion() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E val) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail,index is illegal");
        }
        add(dummyHead, index, 0, val);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get fail,index is illegal");
        }
        return findNode(dummyHead.next, index, 0).val;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E val) {
        findNode(dummyHead.next, index, 0).val = val;
    }

    public boolean contains(E val) {
        return contains(val);
    }

    public E remove(int index) {
        return remove(dummyHead, index, 0);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("size = %d,", size));
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append("->");
            }
            cur = cur.next;
        }

        return sb.toString();
    }
}
