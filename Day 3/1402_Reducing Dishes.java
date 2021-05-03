class Solution {
    
    public int maxSatisfaction(int[] satisfaction) {
        int sum = 0;
        int result = 0;
        int i = 0;
        
        Arrays.sort(satisfaction);
        
        for(i = 0; i < satisfaction.length; ++i) {
            sum += satisfaction[i];
            result += satisfaction[i] * (i + 1);
        }
        
        i = 0;
        
        while(sum < 0) {
            result -= sum;
            sum -= satisfaction[i++];
        }
        
        return result;
    }
}