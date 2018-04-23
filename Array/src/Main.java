public class Main {
    // test
    public static void main(String[] args) {
        Array<Integer> array = new Array<Integer>(6);
        for(int i = 0; i < 5; i++) {
            array.addLast(i);
        }
        System.out.println("init:" + array);
        array.set(4, 20);
        System.out.println("after call set(4,20)" + array);
        array.add(1, 10);
        System.out.println("after call add(1,10)," + array);
        array.add(4, 11);
        System.out.println("after call add(4,11)," + array);
        array.addFirst(12);
        System.out.println("after call addFirst(12)," + array);
        array.removeFirst();
        System.out.println("after removeFirst()," + array);
        array.remove(2);
        System.out.println("after remove(2)," + array);
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        System.out.println("after removeFirst() four times," + array);
    }
}
