package questions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Zuiyou {

    public static void main(String[] args) {

    }

    // 最右手撕题
    // 题目1，找到数组中，后面的数减前面的数的最大差值。（其实就是股票问题，要求用动态规划做）
    static int helper(int[] an) {
        int n = an.length;
        int[] dp = new int[n];
        dp[0] = 0;

        int min = an[0];
        for(int i = 1; i < n; i++) {
            //if(an[i] - min < dp[i - 1]) {

                dp[i] = an[i] - min > dp[i - 1] ? an[i] - min : dp[i - 1];
                min = Math.min(min, an[i]);
        }
        return dp[n - 1];
    }

    // 题目2，寻找给定两个值在二叉树中的最近祖父节点，并且返回根节点到这个结点的路径
    static int[] find(int x, int y, TreeNode root) {
        List<Integer> list = new LinkedList<>();
        dfs(x, y, root, list);
        Collections.reverse(list);

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        //return list.toArray(new int[list.size()]);
        return res;
    }

    static int dfs(int x, int y, TreeNode node, List<Integer> list) {
        if(node == null) {
            return -2;
        }

        int left = dfs(x, y, node.left, list);
        int right = dfs(x, y, node.right, list);

        if(left == -1 || right == -1) {
            list.add(node.val);
            return -1;
        }
        if((left == x && right == y) || (left == y && right == x)) {
            list.add(node.val);
            return -1; // 表示找到了
        }
        if(left == -2) {
            return right;
        }
        if(right == -2) {
            return left;
        }
        return -2;
    }
}
