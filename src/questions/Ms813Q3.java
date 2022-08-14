package questions;

// 题目：数组A中每间隔Y-1个的连续X个数的最小和
// 思路：滑动窗口

public class Ms813Q3 {
    public static void main(String[] args) {
        int[] A = {10,3,4,7};
        int X = 2;
        int Y = 3;
        System.out.println(solution(A, X, Y));
    }

    public static int solution(int[] A, int X, int Y) {
        int n = A.length;
        int res = Integer.MAX_VALUE;
        // 起点只有Y种情况，其他都能由这几个推出
        for(int i = 0; i < Y; i++) {
            int l = i;
            int r = i;
            int sum = 0;
            int count = 0;
            while(r < n) {
                sum += A[r];
                r += Y;
                count++;
                // 当窗口中包含X个数时，窗口不再扩大
                if(count == X) {
                    res = Math.min(res, sum);
                    sum -= A[l];
                    l += Y;
                    count--;
                }
            }
        }
        return res;
    }
}
