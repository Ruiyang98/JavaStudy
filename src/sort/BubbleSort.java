package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3,2,4,1,8,5,9,7,6};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {


        for(int i = 0; i < nums.length - 1; i++) {
            // 冒泡优化，如果某一趟不存在交换元素，直接结束循环。
            boolean flag = false;

            for(int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j + 1] < nums[j]) {
                    swap(nums, j, j + 1);
                    flag = true;    // 如果交换了就设为true
                }
            }
            System.out.println("第"+i+"次排序："+Arrays.toString(nums));

            if(!flag) {
                break;
            }
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
