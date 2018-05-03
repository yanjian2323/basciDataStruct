import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    int n = 1000000;
	    MaxHeap<Integer> maxHeap = new MaxHeap<>(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] data = new int[n];
        for(int i = 0; i < n; i++) {
            data[i] = maxHeap.extractMax();
        }
        for (int i = 0; i < n - 1; i++) {
            if (data[i] < data[i + 1]) {
                System.out.println("i:" + i + "," + data[i] + "," + data[i + 1]);
                System.out.println("排序失败");
                break;
            }
        }
        System.out.println("排序成功");
    }
}
