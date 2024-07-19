// https://leetcode.com/problems/4sum/description/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        for (int r = 0; r < n - 3; r++) {
            if (r > 0 && nums[r] == nums[r - 1]) {
                continue;
            }
            for (int i = r + 1; i < n - 2; i++) {
                if (i > r + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    long total =(long) nums[r] + nums[i] + nums[j] + nums[k];
                    if (total == target) {
                        result.add(Arrays.asList(nums[r], nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    } else if (total < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
