class Solution {
    public String reverseWords(String s) {
        String result = "";
        String[] words = s.split(" ");
        
        for(int i = words.length - 1; i >= 0; --i) {
            String word = words[i];
            if(word.length() > 0) {
                result += word + " ";
            }
        }
        
        result = result.substring(0, result.length() - 1);
        
        return result;
    }
}
/*
Sample Test Cases
=================
"the sky is blue"
"  hello world  "
"a good   example"
"  Bob    Loves  Alice   "
"apple"
*/