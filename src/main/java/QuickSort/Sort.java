package QuickSort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] l = {4,3,7,10,49,12,56,12,4123,12,4,24,25,6,7,812,4,32};
        SortMethod method = new SortMethod();
        method.if_random = true;
        method.quicksort(l, 0, l.length-1);
        System.out.println(Arrays.toString(l));
    }

}

class SortMethod {
    boolean if_random;
    public void quicksort(int[] arr, int left, int right) {
        if (right > arr.length | left < 0) {
            return; // 范围判断
        }
        if (left < right) {
            int p = partition(arr, left, right);
            quicksort(arr, left, p-1);
            quicksort(arr, p+1, right);
        }
    }
    public int partition(int[] arr, int left, int right) {
        if (if_random) {
            int index = (int)(Math.random()*(right-left))+left;
            int pivot = arr[index];
            swap(arr, left, index); // 将随机参数的pivot放到第一的位置
            return subsort(arr, left, right, pivot);
        } else {
            int pivot = arr[left]; //以左边第一个元素为pivot
            return subsort(arr, left, right, pivot);
        }
    }

    private int subsort(int[] arr, int left, int right, int pivot) {
        int i = left;
        for (int j=left+1; j<=right; j++) {
            if (arr[j] <= pivot) {
                i = i + 1;
                swap(arr, i, j);
            }
        }
        swap(arr, left, i);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        // 交换arr[i]与arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
