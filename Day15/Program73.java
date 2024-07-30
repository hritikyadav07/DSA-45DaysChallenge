// https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1

class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        if (s == null || p == null || s.length() < p.length()) {
            return "-1";
        }

        // Frequency map for characters in P
        HashMap<Character, Integer> dictP = new HashMap<>();
        for (char c : p.toCharArray()) {
            dictP.put(c, dictP.getOrDefault(c, 0) + 1);
        }

        int required = dictP.size();
        int l = 0, r = 0;
        int formed = 0;

        // Frequency map for characters in the current window
        HashMap<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0}; // (window length, left, right)

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (dictP.containsKey(c) && windowCounts.get(c).intValue() == dictP.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window till it ceases to be 'desirable'
            while (l <= r && formed == required) {
                c = s.charAt(l);

                // Update the result
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictP.containsKey(c) && windowCounts.get(c).intValue() < dictP.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            // Keep expanding the window
            r++;
        }

        return ans[0] == -1 ? "-1" : s.substring(ans[1], ans[2] + 1);
    }
}