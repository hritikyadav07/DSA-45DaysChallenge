// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n= cardPoints.length;
        int l = n-k;
        int sum = 0;
        int min = 0;
        for(int i = 0;i<n;i++){
            sum+=cardPoints[i];
        }
        for(int i = 0;i<l;i++){
            min+=cardPoints[i];
        }
        int ans = min;
        for(int i=0;i<k;i++){
           min +=(cardPoints[l+i] - cardPoints[i]);
           ans = Math.min(min,ans);
        }
        return sum - ans;
    }
}