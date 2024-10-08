// https://leetcode.com/problems/implement-stack-using-queues/description/

class MyStack {
    
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        while(q1.size() > 1)
        q2.offer(q1.poll());

        int top = q1.poll();

        //put back the elem into the q1 again
        while(q2.size() > 0)
        q1.offer(q2.poll());

        return top;
    }
    
    public int top() {
       // System.out.println(q1);
        while(q1.size() > 1)
        q2.offer(q1.poll());

        int top = q1.poll();

        while(q2.size() > 0)
        q1.offer(q2.poll());

        q1.offer(top); // keep this here

       // System.out.println(q1);
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */