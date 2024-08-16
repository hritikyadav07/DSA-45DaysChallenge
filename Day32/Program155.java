// https://leetcode.com/problems/counting-bits/



class Solution {
    public int countOne(int n) {
        int  count=0;
        System.out.print(n);
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        System.out.println("  "+count);
        return count;
    }
    public int[] countBits(int n) {
        int nums[] = new int[n+1];
        for(int i=0;i<n+1;i++){
            nums[i]=countOne(i);
        }
        return nums;
    }
}