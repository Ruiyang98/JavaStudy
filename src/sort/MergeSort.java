package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {3,2,4,1,8,5,9,7,6};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    //为简化代码，当 j = r + 1 时与当tmp[i] ≤ tmp[j] 时 两判断项可合并。

    private static void mergeSort(int[] nums, int l, int r) {
        // 终止条件
        if (l >= r) return;
        // 递归划分
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);

        // 暂存需合并区间元素
        int[] tmp = new int[r - l + 1];
        for (int k = l; k <= r; k++)
            tmp[k - l] = nums[k];

        // 遍历合并左/右子数组
        int i = 0, j = m - l + 1;       // 两指针分别指向左/右子数组的首个元素
        for (int k = l; k <= r; k++) {
            if (i == m - l + 1)		// 左子数组遍历完成
                nums[k] = tmp[j++];	//直接取右子数组，右子数组指针+1
            else if (j == r - l + 1 || tmp[i] <= tmp[j])//右子数组遍历完 || 左子数组 <= 右子数组（都没遍历完）
                nums[k] = tmp[i++];		// 取左子数组，左子数组指针+1
            else {						// 两个子数组都没遍历完 && 左子数组 > 右子数组
                nums[k] = tmp[j++];		// 取右子数组，右子数组指针+1
            }
        }
    }
}
