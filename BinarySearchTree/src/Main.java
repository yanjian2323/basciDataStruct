public class Main {

    public static void main(String[] args) {
	    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	    bst.add(20);
        bst.add(12);
        bst.add(30);
        bst.add(10);
        bst.add(13);
//        for (int i = 0; i < 10; i++) {
//            bst.add(i + 1);
//        }
        System.out.println("前序遍历：");
	    bst.preOrder();
        System.out.println("前序遍历结束!");
        System.out.println("");

        System.out.println("中序遍历：");
        bst.inOrder();
        System.out.println("中序遍历结束!");
        System.out.println("");

        System.out.println("后序遍历：");
        bst.postOrder();
        System.out.println("后序遍历结束!");
        System.out.println("");

        System.out.println("层序遍历：");
        bst.levelOrder();
        System.out.println("层序遍历结束!");
        System.out.println("");

        System.out.println("最小的元素:" + bst.minimum());
        System.out.println("最大的元素:" + bst.maximum());

//        System.out.println(bst.removeMin());
//        System.out.println(bst.removeMax());

        bst.remove(13);
    }
}
