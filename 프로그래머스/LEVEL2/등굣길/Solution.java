class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] pools = new boolean[m][n];
        for (int[] p : puddles)
            // p[0] = x좌표(열), p[1] = y좌표(행)
            pools[p[0] - 1][p[1] - 1] = true;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 1; i < m; i++)
            // 웅덩이면 0
            dp[i][0] = pools[i][0] ? 0 : dp[i-1][0];

        for (int i = 1; i < n; i++)
            // 웅덩이면 0
            dp[0][i] = pools[0][i] ? 0 : dp[0][i-1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (pools[i][j]) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007;
            }
        }

        return dp[m-1][n-1];
    }
}