class Solution {
    public int minSwapsCouples(int[] row) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int swaps = 0;
        
        for(int i = 0; i < row.length; i += 2) {
            map.put(row[i], row[i + 1]);
            map.put(row[i + 1], row[i]);
        }
        
        for(int i = 0; i < row.length; i += 2) {
            if(map.get(i) != i + 1)
            {
                int cur = map.get(i);
                int next = map.get(i + 1);
                
                map.put(i, i + 1);
                map.put(cur, next);
                map.put(next, cur);
                swaps++;
            }
        }
        
        return swaps;
    }
}