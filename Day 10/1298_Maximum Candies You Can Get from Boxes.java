class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int result = 0;
        int n = status.length;
        int closed[] = new int[n];
        Queue<Integer> opened = new LinkedList<>();
        
        for(int b : initialBoxes) {
            if(status[b] == 1) {
                opened.add(b);
            }
            else {
                closed[b] = 1;
            }
        }
        
        while(!opened.isEmpty()) {
            int b = opened.poll();
            result += candies[b];
            
            for(int k : keys[b]) {
                if(closed[k] == 1) {
                    closed[k] = 0; opened.add(k);
                }
                status[k] = 1;
            }
            
            for(int found : containedBoxes[b]) {
                if(status[found] == 1) {
                    opened.add(found);
                }
                else {
                    closed[found] = 1;
                }
            }
        }
        
        return result;
    }
}