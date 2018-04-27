// 二分搜索树
// 二分搜索数必须满足：当前节点>左节点 && 当前节点<右节点

import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left;
        private Node right;
        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    private int size;//节点个数
    private Node root;//根节点

    // 不能重复添加节点，添加的时候会自动忽略
    // 返回根节点
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        // 小于左节点
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {//大于右节点
            node.right = add(node.right, e);
        }
        return node;
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        }
        // 这样写也行，但是查找效率会比较低
//        return contains(node.left, e) || contains(node.right, e);

        // 从左边找
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {// 从右边走
           return contains(node.right, e);
        }
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    private Node minimum(Node node) {
        if (node == null) return null;
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public Node maximum(Node node) {
        if (node == null) return null;
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    private Node removeMin(Node node) {
        if (node == null) return node;
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node removeMax(Node node) {
        if (node == null) return node;
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 删除任意一个节点，返回根节点
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
        } else {// 找到了要删除的节点
            if (node.left == null) {
                Node delNode = node.right;
                size--;
                node.right = null;
                return delNode;
            }
            if (node.right == null) {
                Node delNode = node.left;
                size--;
                node.left = null;
                return delNode;
            }
            // 左右节点都不为空的情况
            Node successor = minimum(node.right);
            removeMin(node.right);
            successor.left = node.left;
            successor.right = node.right;

            node.left = null;
            node.right = null;

            return successor;
        }
        return node;
    }


    public BinarySearchTree() {
        size = 0;
        root = null;
    }
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 添加一个节点
    public void add(E e) {
        root = add(root, e);
    }

    // 查看元素是否存在
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 后续遍历
    public void postOrder() {
        postOrder(root);
    }

    // 层序遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.e);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    // 最小值
    public E minimum() {
        return minimum(root).e;
    }

    // 最大值
    public E maximum() {
        return maximum(root).e;
    }

    // 删除最小值
    public E removeMin() {
        E ret = minimum();
        // 一定要把removeMin的返回值赋值给root，兼容下面这个情况
        // 1
        //   2
        //     3
        root = removeMin(root);

        return ret;
    }

    // 删除最大值
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);

        return ret;
    }

    public void remove(E e) {
        root = remove(root, e);
    }
}
