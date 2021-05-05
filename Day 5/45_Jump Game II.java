class Solution {
    
    static int N;
    static int INF;
    
    public int jump(int[] nums) {
        N = nums.length;
        INF = N + 10;
        int[] dp = new int[N];
        dp[N - 1] = 0;
        
        for(int i = N - 2; i >= 0; --i) {
            dp[i] = INF;
            
            for(int j = 1; j <= nums[i] && i + j < N; ++j) {
                dp[i] = Math.min(dp[i], dp[i + j] + 1);
            }
        }
        
        return dp[0];
    }
    
}