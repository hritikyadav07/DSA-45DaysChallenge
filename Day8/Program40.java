// https://leetcode.com/problems/implement-queue-using-stacks/description/


class MyQueue {
    Deque<Integer> stk ; 
    public MyQueue() {
        stk = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stk.push(x);
    }
    
    public int pop() {
        Deque<Integer> stk2 = new ArrayDeque<>();
        while(!stk.isEmpty())
        stk2.push(stk.pop());

        int ans = stk2.pop(); 

        while(!stk2.isEmpty())
        stk.push(stk2.pop());

        return ans;
    }
    
    public int peek() {
        Deque<Integer> stk2 = new ArrayDeque<>();
        while(!stk.isEmpty())
        stk2.push(stk.pop());

        int ans = stk2.peek();

        while(!stk2.isEmpty())
        stk.push(stk2.pop());

        return ans;
    }
    
    public boolean empty() {
        if(stk.isEmpty()) 
        return true;

        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */