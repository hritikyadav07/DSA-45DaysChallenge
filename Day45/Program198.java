// https://leetcode.com/problems/gas-station/description/


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gas_left = 0;
        int gas_required = 0;
        int index = 0;
        for(int i =0;i<gas.length;i++){
            gas_left += (gas[i]-cost[i]);
            if(gas_left<0){
                gas_required -= gas_left;
                gas_left = 0;
                index = i+1;
            }
        }
        if(gas_left>= gas_required)return index;
        return -1;
    }
}
