class Solution {
    
    long[][][] memo;
    final long MOD = (long)1e9 + 7;
    int N;
    int M;
    
    public int numOfArrays(int n, int m, int K) {
        long ans = 0;
        memo = new long[n + 1][m + 1][K + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= K; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        
        N = n;
        M = m;
        
        for (int i = 1; i <= m; i++) {
            ans = (ans + rec(1, i, K - 1)) % MOD;
        }
        
        return (int) ans;
    }
    
    private long rec(int i, int msf, int kLeft) {
        if (i == N) {
            return kLeft == 0 ? 1 : 0;
        }
        
        if (kLeft < 0) return 0;
        
        if (memo[i][msf][kLeft] != -1)  return memo[i][msf][kLeft];
        
        long ans = 0;
        
        for (int j = 1; j <= M; j++) {
            ans = (ans + rec(i + 1, Math.max(msf, j), j > msf ? kLeft-1 : kLeft)) % MOD;
        }
                   
        return memo[i][msf][kLeft] = ans;
    }
    
}