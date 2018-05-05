public class Main {

    public static void main(String[] args) {
	    Integer[] data = {1,2,3,4,5,6,7,8};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(data, (Integer a, Integer b) -> a + b);
        System.out.println(segmentTree);
        System.out.println("index[3-4]:" + segmentTree.query(1,4));
        segmentTree.set(1, 5);
        System.out.println(segmentTree);
        System.out.println("after call set(3,5),index[3-4]:" + segmentTree.query(1,4));
    }
}

