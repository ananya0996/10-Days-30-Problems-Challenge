class Solution {
    
    class Frequency {
        char letter;
        int count;
        
        public Frequency(char _letter, int _count) {
            letter = _letter;
            count = _count;
        }
    }
    
    public String reorganizeString(String S) {
        PriorityQueue<Frequency> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0;
        char[] result = new char[S.length()];
        
        for(int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(char key : map.keySet()) {
            maxHeap.offer(new Frequency(key, map.get(key)));
        }
        
        if(maxHeap.peek().count > (S.length() + 1) / 2) {
            return "";
        }
        
        while(!maxHeap.isEmpty()) {
            Frequency freq = maxHeap.poll();
            
            for(int i = 0; i < freq.count; ++i) {
                result[index] = freq.letter;
                index += 2;
                if(index >= S.length()) {
                    index = 1;
                }
            }
        }
        
        return String.valueOf(result);
    }
}

/*
Sample Test Cases
=================
"aab"
"aaab"
"aaaabcc"
"aaaabccd"
"aaaabccdd"
"yeczrrgrpeaalvaofyjhslssdujxatdkphxmgktleahuholazhyhprrtdzccljadisktroeopixunnlhjuxictstlreaogribuuekisuonbedjnzjaqgeqfuhxwqmqtchzrpwtywdmrrohjiqsfeptwhpndjzkbfqoxybdcxccjmnqntgvlsxjryxzdtouizfmvgvnlvjrenppnexjysslatybdiflizokymaslxfgbsqrulzatnqvxnveetehgmoscihlbbeiwnawnefgwoslbjiedvbojpvjjwvnbwdfrghzmrlwuzzdxudztbfakmzklcrdcdqfovualwnyrqvkswrtvriqchpmczfdacmscsvbgneulkxueepgucetbdugezyqrlysabqijcrxjlwbibwdqbuytyqaouypmlofqdgihookdmrkbdnhceguqnlzspdczmfvwqzbtnggtaofeztamhtyqragxsvcqnhviuwfnmtyfg"
*/