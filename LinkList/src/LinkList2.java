// 实现链表,使用虚拟头节点
public class LinkList2<E> {
    private class Node {
        private E val;
        private Node next;
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
    private int size;//节点个数
    private Node dummyHead;//虚拟头节点

    // 通过索引得到节点
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get fail,index is illegal,index = " + index);
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public LinkList2() {
        size = 0;
        dummyHead = new Node(null, null);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail,index is illegal,index = " + index);
        }
        Node prev = dummyHead;
        for(int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    // 根据索引得到节点的val
    public E get(int index) {
        Node node = getNode(index);
        return node.val;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        Node node = getNode(index);
        node.val = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (get(i) == e) {
                return true;
            }
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove fail,index is illegal,index = " + index);
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node willDelNode = prev.next;
        prev.next = willDelNode.next;
        size--;
        // willDelNode和之后的链表脱离关系
        // 并不需要执行willDelNode=null，willDelNode是局部变量，函数执行完会自动回收
        willDelNode.next = null;
        return willDelNode.val;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    // 删除链表中值为e的节点，只删除第一个，后边相同值为e的不删除
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == e) {
                Node willDelNode = prev.next;
                prev.next = willDelNode.next;
                willDelNode.next = null;
                size--;
                break;
            } else {
                prev = prev.next;
            }
        }
    }

    // 删除链表中值为e的所有节点
    public void removeElements(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == e) {
                Node willDelNode = prev.next;
                prev.next = willDelNode.next;
                willDelNode.next = null;
                size--;
            } else {
                prev = prev.next;
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[size = %d],", size));
        for (int i = 0; i < size; i++) {
            sb.append(get(i));
            if (i < size - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}

