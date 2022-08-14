package questions;

// 题目：给分子和分母，求两个数之和为1的组合数。

public class Ms813Q2 {
    public static void main(String[] args) {

    }

    public static int solution(int[] X, int[] Y) {
        int mod = (int) (1e9 + 7);
        int n = X.length;
        int res = 0;

        return res;
    }

    // 辗转相除法，下一轮的除数是余数，被除数是除数
    public static int gcd(int a, int b) {
        int tmp = a % b;
        while(tmp != 0) {
            a = b;
            b = tmp;
            tmp = a % b;
        }
        return b;
    }
}
