// https://www.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/0


class Solution {
    static void backtrack(List<Integer> arr, List<Integer> partial, ArrayList<ArrayList<Integer>> result, boolean[] visited) {
        if (partial.size() == arr.size()) {
            result.add(new ArrayList<>(partial));
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (visited[i] || (i > 0 && arr.get(i) == arr.get(i - 1) && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            partial.add(arr.get(i));
            backtrack(arr, partial, result, visited);
            partial.remove(partial.size() - 1);
            visited[i] = false;
        }
    }

    static ArrayList<ArrayList<Integer>> uniquePerms(List<Integer> arr, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr.size() == 0) return result;
        Collections.sort(arr);
        List<Integer> partial = new ArrayList<>();
        boolean[] visited = new boolean[arr.size()];
        backtrack(arr, partial, result, visited);
        return result;
    }
}