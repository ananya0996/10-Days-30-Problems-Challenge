class Solution {
    
    /*O(n) Method*/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>(k);
        int start = 0;
        int end = arr.length - 1;
        
        while(end - start + 1 > k) {
            if(distance(arr[start], arr[end], x) > 0) {
                end--;
            }
            else {
                start++;
            }
        }
        
        for(int i = start; i <= end; ++i) {
            result.add(arr[i]);
        }
        return result;
    }
    
    /***********************************/
    
    /*Naive Method*/
    public List<Integer> findClosestElementsOld(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> distance(a, b, x));
        List<Integer> result = new ArrayList<>(k);
        
        for(int ele : arr) {
            maxHeap.add(ele);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        while(!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }
        
        Collections.sort(result);
        
        return result;
    }
    
    private int distance(int a, int b, int x) {
        int A = Math.abs(a - x);
        int B = Math.abs(b - x);
        
        return A == B ? b - a : B - A;
    }
}