// https://leetcode.com/problems/climbing-stairs


class Solution {
    public int climbStairs(int n) {
        int a[]= new int[n];
        a[0]=1;           //for step 1 theree are 1 ways
        if(n>=2){
            a[1]=2;         //for step 2 there are two ways
            for(int i=2;i<n;i++)
            a[i]=a[i-1]+a[i-2];         //similarly for consecutive steps either the person is coming for n-1 step or n-2 step for adding bothwe get all ways to reach nth step
        }
        return a[n-1];
    }
}