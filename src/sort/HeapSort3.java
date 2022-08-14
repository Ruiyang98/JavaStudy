package sort;

import java.util.Arrays;

public class HeapSort3 {
    public static void main(String[] args) {
        int[] arr = {3,1,4,2,8,5,9,7,6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }

        // 构建大顶堆
        buildMaxHeap(arr);

        // 交换堆顶元素和末尾元素，重置大顶堆
        for(int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }

    }

    private static void buildMaxHeap(int[] arr) {
        // 从第一个非叶子结点从下至上，从右至左调整结构
        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }

    private static void adjustHeap(int[] arr, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if(left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if(largest != i) {
            swap(arr, i, largest);
            adjustHeap(arr, largest, heapSize);
        }
    }


    public static void swap(int[] arr, int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
