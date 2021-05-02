class Solution {
    public int minimumSwap(String s1, String s2) {
        int swaps = -1;
        int c1[] = new int[2];
        int c2[] = new int[2];

        for(int i = 0; i < s1.length(); ++i) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            
            if(ch1 == ch2) {
                continue;
            }
            
            c1[ch1 - 'x']++;
            c2[ch2 - 'x']++;
        }
        
        if((c1[0] + c2[0]) % 2 != 0 || (c1[1] + c2[1]) % 2 != 0){
            return swaps;
        }
        
        swaps = (c1[0] / 2) + (c1[1] / 2); // total # of pairs of 'x' and 'y' across both strings
        swaps += (c1[0] % 2) * 2; // remaining number of 'x'

        return swaps; 
    }
}