public class Main {

    public static void main(String[] args) {
	    LinkList2<Integer> linklist = new LinkList2<>();
	    for (int i = 0; i < 5; i++) {
	        linklist.add(i, i + 1);
        }
        System.out.println("linkList 2 init:" + linklist);
	    System.out.println("first Node:" + linklist.getFirst());
        System.out.println("last Node:" + linklist.getLast());
        System.out.println("index 2 node:" + linklist.get(2));
        linklist.removeFirst();
        System.out.println("after call removeFirst()," + linklist);
        linklist.removeLast();
        System.out.println("after call removeLast()," + linklist);
        linklist.remove(1);
        System.out.println("after call remove(1)," + linklist);
        linklist.addLast(2);
        System.out.println("after call addLast(2)," + linklist);
        linklist.removeElements(2);
        System.out.println("after call removeElements(2)," + linklist);

        System.out.println("");

        LinkListRecursion<Integer> linklistRecursion = new LinkListRecursion<>();
        for (int i = 0; i < 5; i++) {
            linklistRecursion.addLast(i + 1);
        }

        System.out.println("linklistRecursion init:" + linklistRecursion);
        System.out.println("first Node:" + linklistRecursion.getFirst());
        System.out.println("last Node:" + linklistRecursion.getLast());
        System.out.println("get(2):" + linklistRecursion.get(2));
        linklistRecursion.removeFirst();
        System.out.println("after call removeFirst()," + linklistRecursion);
        linklistRecursion.removeLast();
        System.out.println("after call removeLast()," + linklistRecursion);
        linklistRecursion.set(1, 300);
        System.out.println("after call set(1, 33)," + linklistRecursion);
    }
}
