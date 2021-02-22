package microsoft;

/**
 * @author yeweixiong
 * @date 2020/12/30 11:51
 */
public class MedianFinder {
    private int[] arr;
    private int size;

    public MedianFinder() {
        arr = new int[32];
        size = 0;
    }

    public void capacity() {
        if (size == arr.length) {
            //翻倍扩容
            int[] tmp = arr;
            arr = new int[size * 2];
            System.arraycopy(tmp, 0, arr, 0, size);
        }
    }

    public void addNum(int num) {
        capacity();
        arr[size] = num;
        siftUp();
        size++;
    }

    public double findMedian() {
        int mid = size / 2;
        return (size & 1) == 1 ? arr[mid] : (arr[mid] + arr[mid - 1]) / 2.0;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private void siftUp() {
        int index = size;
        int parent = getParent(index);
        while (index > 0 && arr[parent] > arr[index]) {
            swap(parent, index);
            index = parent;
            parent = getParent(index);
        }
    }

    private void swap(int parent, int index) {
        arr[parent] = arr[parent] ^ arr[index];
        arr[index] = arr[parent] ^ arr[index];
        arr[parent] = arr[parent] ^ arr[index];
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);


        System.out.println(medianFinder.findMedian());

    }
}
