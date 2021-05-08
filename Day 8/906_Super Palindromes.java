class Solution {
    
    public int superpalindromesInRange(String left, String right) {
        int result = 0;
        long L = Long.valueOf(left);
        long R = Long.valueOf(right);
        List<Long> palindromes = new ArrayList<>();
        
        for(long i = 1; i < 9; ++i) {
            palindromes.add(i);
        }
        
        for(int i = 1; i < 10_000; ++i) {
            String leftHalf = Long.toString(i);
            String rightHalf = new StringBuilder(leftHalf).reverse().toString();
            palindromes.add(Long.parseLong(leftHalf + rightHalf));
            for(long d = 0; d < 10; ++d) {
                palindromes.add(Long.parseLong(leftHalf + d + rightHalf));
            }
        }
        
        for(long palindrome : palindromes) {
            long square = palindrome * palindrome;
            if(!isPalindrome(Long.toString(square))) {
                continue;
            }
            if(L <= square && square <= R) {
                result++;
            }
        }
        
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}