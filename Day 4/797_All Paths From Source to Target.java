class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        
        for(int i = 0; i < graph[0].length; ++i) {
            List<Integer> path = new ArrayList<>();
            path.add(0);
            dfsPathSearch(graph, graph[0][i], path);
        }
        
        return result;
    }
    
    private void dfsPathSearch(int[][] graph, int curNode, List<Integer> path) {
        path.add(curNode);
        
        if(curNode == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int neighbor : graph[curNode]) {
            dfsPathSearch(graph, neighbor, path);
            path.remove(path.size() - 1);
        }
    }
}

/*
Sample Test Cases
=================
[[1,2],[3],[3],[]]
[[4,3,1],[3,2,4],[3],[4],[]]
[[1],[]]
[[1,2,3],[2],[3],[]]
[[1,3],[2],[3],[]]
*/