class StockSpanner {
    
    Stack<int[]> quotes;

    public StockSpanner() {
        quotes = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        while(!quotes.isEmpty() && quotes.peek()[0] <= price) {
            span += quotes.peek()[1];
            quotes.pop();
        }
        
        quotes.push(new int[] {price, span});
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */