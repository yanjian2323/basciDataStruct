public class Main {

    public static void main(String[] args) {
        // 普通队列
	    ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
	    for (int i = 0; i < 5; i++) {
	        arrayQueue.enqueue(i);
        }
        System.out.println("init:" + arrayQueue);
	    arrayQueue.dequeue();
        arrayQueue.dequeue();
        System.out.println("after call dequeue two times:" + arrayQueue);
        arrayQueue.enqueue(10);
        System.out.println("after call enqueue(10):" + arrayQueue);

        System.out.println("");

        // 循环队列
        LoopQueue<Integer> loopQueue = new LoopQueue<>(3);
        for (int i = 0; i < 5; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println("init:" + loopQueue);
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        System.out.println(loopQueue);
//        System.out.println("after call dequeue:" + loopQueue);
        System.out.println("");

        //基于栈的队列
        LinkListQueue<Integer> linkListQueue = new LinkListQueue<>();
        for (int i = 0; i < 5; i++) {
            linkListQueue.enqueue(i);
        }
        System.out.println("linklist init:" + linkListQueue);
        linkListQueue.dequeue();
        linkListQueue.dequeue();
        System.out.println("after call dequeue two times:" + linkListQueue);
    }
}
