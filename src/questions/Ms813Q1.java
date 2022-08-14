package questions;

import java.util.Comparator;
import java.util.PriorityQueue;

// 题目：将A中的数字减少一半，最少需要多少次后，数组的和小于等于原来数组和的一半
// 思路：贪心+大根堆，每次取最大的减半，得到的就是最少次数
public class Ms813Q1 {

    public static void main(String[] args) {

    }

    public static int solution(int[] A) {
        // 法1
        PriorityQueue<Double> heap = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1 > o2 ? -1 : 1;
                // return (int) (o2 - o1);
            }
        });


        int res = 0;
        double sum = 0.0;
        for(int a : A) {
            heap.add((double) a);
            sum += a;
        }

        double cur = 0.0;
        while(cur < sum / 2) {
            double max = heap.poll();
            cur += max / 2;
            heap.offer(max / 2);
            res++;
        }
        return res;
    }
}
