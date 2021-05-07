class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];
        int size = 0;
        List<Integer> perm = new LinkedList<>();
        
        for(int i = 1; i <= m; ++i) {
            perm.add(i);
        }
        
        for(int query : queries) {
            int index = perm.indexOf(query);
            result[size++] = index;
            perm.remove(index);
            perm.add(0, query);
        }
        
        return result;
    }
}