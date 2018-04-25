public class Main {

    public static void main(String[] args) {
//	    ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkListStack<Integer> arrayStack = new LinkListStack<>();
	    for (int i = 0; i < 5; i++) {
	        arrayStack.push(i);
        }
        System.out.println("init:" + arrayStack);
	    arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
//        arrayStack.pop();
//        arrayStack.pop();
	    System.out.println("after call pop three times," + arrayStack);
	    System.out.println("size=" + arrayStack.getSize());

    }
}
