// https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1


class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        long mindif = Integer.MAX_VALUE;
        Collections.sort(a);
        int i=0;
        for(int k=m-1;k<n;k++,i++){
            if((a.get(k)-a.get(i))<mindif){
                mindif = a.get(k)-a.get(i);
            }
        }
        return mindif;
    }
}