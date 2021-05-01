class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // query_glass + 2 -> extra 1 space to factor in extra champagne poured in the
        // corner glasses that falls onto the floor
        double[][] triangle = new double[query_row + 1][query_glass + 2];
        
        triangle[0][0] = poured;
        
        for(int i = 0; i < query_row; ++i) {
            for(int j = 0; j <= query_glass; ++j) {
                double remaining = Math.max(0.0, triangle[i][j] - 1);
                triangle[i + 1][j] += remaining / 2;
                triangle[i + 1][j + 1] += remaining / 2;
            }
        }
        
        // If there are still > 1 cups of champagne left after query, return 1
        return Math.min(1.0, triangle[query_row][query_glass]);
    }
}