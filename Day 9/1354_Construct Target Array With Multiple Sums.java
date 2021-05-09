class Solution {
    public boolean isPossible(int[] target) {
        boolean possible = true;
        int sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(target.length, (a, b) -> b - a);
        for(int num : target) {
            sum += num;
            maxHeap.offer(num);
        }
        
        while(possible && !(maxHeap.peek() == 1)) {
            int top = maxHeap.poll();
            int remainingSum = sum - top;
            
            if(top <= remainingSum || remainingSum < 1) {
                possible = false;
            }
            else {
                top %= remainingSum;
                sum = remainingSum + top;
                maxHeap.offer(top);
            }
        }
        
        return possible;
    }
}
/*
Sample Test Cases
=================
[9,3,5]
[1,1,1,2]
[8,5]
[1,1000000000]
[1,1,2]
*/