package array;

import java.util.concurrent.ThreadLocalRandom;

public class Sort {
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }


    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        //基准,随机产生
        int index = random.nextInt(right - left) + left;

        while (i < j) {
            while (i < j && arr[j] > index) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }

            while (i < j && arr[i] < index) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = index;

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);

    }

    public static void main(String[] args) {
        int[] arr = {23, 234, 45, 345, 3213, 43, 453, 464, 564, 57, 567, 56, 234};

        quickSort(arr);

        for (int i : arr) {
            System.out.println(i + ", ");
        }
    }


}
