class Solution {
    
    static final int FILLED = 1;
    
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int lastFilledSeat = -1;
        int maxDistance = 0;
        
        for(int i = 0; i < N; ++i) {
            if(seats[i] == FILLED) {
                maxDistance = (lastFilledSeat == -1) ? i
                                : Math.max(maxDistance, (i - lastFilledSeat) / 2);
                lastFilledSeat = i;
            }
        }
        
        maxDistance = Math.max(maxDistance, N - lastFilledSeat - 1);
        
        return maxDistance;
    }
}