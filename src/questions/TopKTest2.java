package questions;

import java.util.*;

// 题目：求数组nums中最大的5个数

public class TopKTest2 {
    static int[] nums={6,14,71,21,9,18,7,4,23,0,45,66};

    public static void main(String[] args) {
        topK();
    }

    public static void topK() {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i=0; i<5; i++) {
            queue.add(nums[i]);
        }
        for(int i=5; i<12; i++) {
            if(nums[i] > queue.element()) {
                queue.remove();
                queue.add(nums[i]);
            }
        }
        while(!queue.isEmpty()) {
            int Ele=queue.remove();
            System.out.print(Ele+" ");
        }
    }
}
