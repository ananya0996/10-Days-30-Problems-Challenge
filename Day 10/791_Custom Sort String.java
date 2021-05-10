class Solution {
    public String customSortString(String order, String str) {
        int[] priority = new int[26];
        String result = "";
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> priority[a - 'a'] - priority[b - 'a']);
        
        for(int i = 0; i < order.length(); ++i) {
            priority[order.charAt(i) - 'a'] = i + 1;
        }
        
        for(int i = 0; i < str.length(); ++i) {
            maxHeap.offer(str.charAt(i));
        }
        
        while(!maxHeap.isEmpty()) {
            result += maxHeap.poll();
        }
        
        return result;
    }
}