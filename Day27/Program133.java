// https://www.geeksforgeeks.org/problems/circular-tour-1587115620/1

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[]){
        int need = 0, start=0, excess = 0;
        for(int i = 0;i<petrol.length;i++){
            //remaining petrol added here 
            excess += (petrol[i]-distance[i]);
            //if remaining pettrol is less 
            if(excess<0){
                start = i+1;
                // this much petrol will be need on the back trip or circular trip
                need+=excess;
                excess=0;
            }
        }
        // the excess petrol can cover the need distance on circular trip
        if(excess+need>=0) return start;
        else return -1;
    }
}