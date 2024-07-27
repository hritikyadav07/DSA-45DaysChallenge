// https://www.geeksforgeeks.org/problems/permutations-in-array1747/1


class Solution {
    public boolean isPossible(long a[], long b[], int n, long k) {
        // Your code goes here
        Arrays.sort(a);
        Long[] longArray = Arrays.stream(b).boxed().toArray(Long[]::new);

        // Custom comparator for descending order
        Comparator<Long> descendingOrder = new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1); // Compare in reverse order
            }
        };

        // Sorting the array using the custom comparator
        Arrays.sort(longArray, descendingOrder);

        // Convert Long[] back to long[]
        b = Arrays.stream(longArray).mapToLong(Long::longValue).toArray();
        for(int i =0;i<n;i++){
            if(a[i]+b[i]<k){
                return false;
            }
        }
        return true;
    }
}