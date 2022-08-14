package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3,2,4,1,8,5,9,7,6};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            // 向后移动数组
            while(j >= 0 && arr[j] > tmp) {
                arr[j + 1]  = arr[j];
                j--;
            }
            // 插入
            arr[j + 1] = tmp;
            System.out.println("第"+i+"次排序："+Arrays.toString(arr));
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
