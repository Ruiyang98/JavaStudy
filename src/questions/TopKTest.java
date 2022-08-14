package questions;


import java.util.PriorityQueue;

// 题目：给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。你需要找的是数组
//      排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
public class TopKTest {
    public static void main(String[] args) {
        //int[] arr = new int[]{3,2,1,5,6,4};
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        test(arr,k);
    }


    /**
     * 方法三：PriorityQueue 优先队列思想
     * 返回数组第k个最大数据
     * @param nums
     * @param k
     */
    public static int findKthLargest3(int[] nums, int k){   //时间复杂度：O(NlogK)，遍历数据 O(N)，堆内元素调整 O(K)，空间复杂度：O(K)
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆
        // k 堆的初始容量，(a,b) -> a -b 比较器
        PriorityQueue<Integer> minTop = new PriorityQueue<>(k,(a, b) -> a -b);
        for (int i = 0; i < k; i++){
            minTop.add(nums[i]);
        }
        for (int i = k; i < len; i++){
            Integer topEle = minTop.peek();  // 返回队头元素（不删除），失败时前者抛出null
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topEle){
                minTop.poll();  // 获取队头元素并删除，并返回，失败时前者抛出null，再调整堆结构
                minTop.offer(nums[i]);  // 在队尾插入元素，插入失败时抛出false，并调整堆结构
            }
        }
        return minTop.peek();
    }

    public static void test(int[] input,int key){
        long begin = System.currentTimeMillis();

        int result = findKthLargest3(input,key);
        System.out.println("result = " + result);

        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("耗时:" + (end - begin) + "ms");
        System.out.println("--------------------");
    }
}
