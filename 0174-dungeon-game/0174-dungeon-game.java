class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // dp[i][j] = minimum HP needed to reach the princess from cell (i, j)
        int[][] dp = new int[m + 1][n + 1];

        // Initialize with max value
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Set the base case: just beyond the princess cell needs 1 HP
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        // Fill DP table from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
            }
        }

        return dp[0][0];  // Minimum initial health needed at the start
    }
}
