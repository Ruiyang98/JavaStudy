package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {3,2,4,1,8,5,9,7,6};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void shellSort(int[] nums) {
        //增量序列的选择没有具体的公式，可以根据自己的数据取个合适的增量序列
        for (int increment = nums.length/2; increment > 0 ; increment = increment / 2) {
            //根据增量对数组进行分组
            for (int i = increment; i < nums.length; i++) {
                int index = i;
                //进行插入排序
                //注意：index-increment值的变化
                while ((index - increment  >= 0) && (nums[index] < nums[index-increment])) {
                    int temp = nums[index];
                    nums[index] = nums[index - increment];
                    nums[index - increment] = temp;
                    index =index - increment;
                }
            }
        }
    }


}
