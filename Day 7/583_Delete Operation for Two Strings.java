class Solution {
    public int minDistance(String word1, String word2) {
        int M = word1.length();
        int N = word2.length();
        
        int[][] dp = new int[M + 1][N + 1];
        Arrays.fill(dp[0], 0);
        fillColumn(dp, 0, 0);
        
        for(int i = 1; i <= M; ++i) {
            for(int j = 1; j <= N; ++j) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        return word1.length() + word2.length() - (2 * dp[M][N]);
    }
    
    private void fillColumn(int[][] array, int col, int val) {
        for(int r = 0; r < array.length; ++r) {
            array[r][col] = val;
        }
    }
}

/*
Sample Test Cases
=================
"dog"
"cat"
"leetcode"
"etco"
"sea"
"eat"
"intention"
"execution"
*/