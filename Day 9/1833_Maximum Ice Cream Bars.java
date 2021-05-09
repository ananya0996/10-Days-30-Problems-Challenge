class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int count = 0;
        
        Arrays.sort(costs);
        
        for(int cost : costs) {
            if(coins - cost >= 0) {
                coins -= cost;
                count++;
            }
        }
        
        return count;
    }
}