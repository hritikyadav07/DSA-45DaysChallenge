// https://leetcode.com/problems/flatten-nested-list-iterator/description/


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stk = new  ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        prepareStack(nestedList);  
    }

    @Override
    public Integer next() {
        if(!hasNext())
        return null;
        return stk.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stk.isEmpty()&&!stk.peek().isInteger()){
            List<NestedInteger> li = stk.pop().getList();
            prepareStack(li);
        }
        return !stk.isEmpty();
    }
private void prepareStack(List<NestedInteger>li){
    for(int i = li.size()-1;i>= 0;i--)
    stk.push(li.get(i));
}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */