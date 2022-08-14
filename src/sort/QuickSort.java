package sort;

import java.util.Arrays;


public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,1,4,2,8,5,9,7,6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }



    private static void quickSort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }

        int i = partition(nums, l, r);
        // System.out.print(i);
        // System.out.println(Arrays.toString(nums));
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);

    }

    private static int partition(int[] nums, int l, int r) {
        // 随机选取哨兵
        // int index = (int) (Math.random() * (r - l) + l);
        // int tmp = nums[index];
        int tmp = nums[l];

        int i = l;
        int j = r;
        while(i < j) {
            /*
            1、必须先移动j，再移动i
            2、先从右往左，可以找到较小数和基准数交换
            举个例子，数组[2, 1, 3]，先从右往左，会交换1和2；如果先从左往右，便会交换2和3
            当然，你也可以先从左往右，前提是设置num[r]（最后一个数）为基准数，找到较大数和基准数交换
             */

            while(i < j && nums[j] >= tmp) {
                j--;
            }
            while(i < j && nums[i] <= tmp) {
                i++;
            }
            swap(nums, i, j);
        }
        // 这里交换l和i，交换后其左边元素都比他小，右边元素都比他大
        swap(nums, i, l);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
