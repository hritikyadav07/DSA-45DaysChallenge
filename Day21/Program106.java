// https://www.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1


class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        PriorityQueue<Integer> att = new PriorityQueue<>() ;
        for(int i:arr){
            if(i>0) att.offer(i);
        }
        int counter = 1;
        while(!att.isEmpty() && counter ==att.peek()){
            while(!att.isEmpty() && counter ==att.peek()){
                att.poll();
            }
            counter++;
        }
        return counter;
    }
}