class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    
    public int getKth(int lo, int hi, int k) {        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> powerOf(a) == powerOf(b) ? b - a : powerOf(b) - powerOf(a));
        
        dp.put(1, 0);
        
        for(int i = lo; i <= hi; ++i) {
            minHeap.offer(i);
        }
        
        while(minHeap.size() > k) {
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
    
    private int powerOf(int num) {
        if(!dp.containsKey(num)) {
            dp.put(num, 1 + powerOf(num % 2 == 0 ? num / 2 : num * 3 + 1));
        }
        
        return dp.get(num);
    }
}

/*
Sample Test Cases
=================
12
15
2
1
1
1
7
11
4
10
20
5
1
1000
777
*/