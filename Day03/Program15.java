// https://leetcode.com/problems/merge-sorted-array/description/

import java.util.ArrayList;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> sort = new ArrayList<>();
        int i=0, j=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                sort.add(nums1[i++]);
            }else{
                sort.add(nums2[j++]);
            }
        }
        while(i<m){
            sort.add(nums1[i++]);
        }
        while(j<n){
            sort.add(nums2[j++]);
        }
        for(int k = 0;k<m+n;k++){
            nums1[k]=sort.get(k);
        }
    }
}
