package questions;


// 题目：最长回文子序列

class test2 {
    public int longestPalindromeSubseq(String s) {

        int n=s.length();

        //先将String转换为StringBuilder类型
        StringBuilder str=new StringBuilder(s);
        //在调用StringBuilder的反转函数，之后输出toString类型变为字符串类型
        String s1=str.reverse().toString();

        //StringBuffer str = new StringBuffer();

        int [][]dp=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s1.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][n];    //输入序列长度-dp[n][n]


    }
}
