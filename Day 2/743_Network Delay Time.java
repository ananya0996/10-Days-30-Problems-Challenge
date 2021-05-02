class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer,Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n + 1];
        int totalTime = 0;
        
        for(int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x, y) -> (x[0] - y[0]));
        
        minHeap.offer(new int[] {0, k});
        
        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.remove();
            int curDist = cur[0];
            int curNode = cur[1];
            
            if(visited[curNode]) {
                continue;
            }
            
            visited[curNode] = true;
            totalTime = curDist;
            n--;
            
            if(map.containsKey(curNode)) {
                for(int next : map.get(curNode).keySet()) {
                    minHeap.offer(new int[] {curDist + map.get(curNode).get(next), next});
                }
            }
        }
        
        totalTime = (n == 0) ? totalTime : -1;
        
        return totalTime;
    }
}