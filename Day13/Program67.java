// https://leetcode.com/problems/online-stock-span/

class StockSpanner {
    ArrayList<Integer> li;
    Deque<Integer> stk;
    int indx;
    public StockSpanner() {
        li = new ArrayList<>();
        stk = new ArrayDeque<>();
        indx = -1;
    }
    public int next(int price) {
        indx++;
        while (!stk.isEmpty() && price >= li.get(stk.peek()))
            stk.pop();
        int PGI = stk.isEmpty() ? -1 : stk.peek();
        stk.push(indx);
        li.add(price);
        return indx - PGI;
    }
}
