// https://leetcode.com/problems/ugly-number-ii/description/


class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        long ugly = 1;
        pq.offer(ugly);
        seen.add(ugly);

        long[] primes= {2, 3, 5};

        for(int i=0;i<n;i++){
            ugly = pq.poll();
            for(long prime:primes){
                long newUgly = ugly*prime;
                if(!seen.contains(newUgly)){
                    seen.add(newUgly);
                    pq.add(newUgly);
                }
            }
        }
        return (int)ugly;
    }
}