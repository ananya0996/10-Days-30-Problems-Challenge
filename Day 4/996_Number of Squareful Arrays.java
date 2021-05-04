class Solution {
    
    private int count = 0;
    
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        
        numSquarefulPerms(new ArrayList<>(), A, new boolean[A.length], -1);
        
        return count;
    }
    
    
    private void numSquarefulPerms(List<Integer> list, int[] A, boolean[] used, int last) {
        if(list.size() == A.length) {
            count++;
        }
        else {
            for(int i = 0; i < A.length; i++){
                if(used[i] || (i > 0 && A[i] == A[i - 1] && !used[i - 1])) {
                    continue;
                }
                
                if(last != -1) {
                    if(isSquare(A[i], last) == false) {
                        continue;
                    }
                }
                
                used[i] = true;
                list.add(A[i]);
                numSquarefulPerms(list, A, used, A[i]);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
        
    }
    
    private boolean isSquare(int x, int y) {
        double squareRoot = Math.sqrt(x + y);
        
        return squareRoot - Math.floor(squareRoot) == 0;
    }
}

/*
Sample Test Cases
=================
[1,17,8]
[2,2,2]
*/