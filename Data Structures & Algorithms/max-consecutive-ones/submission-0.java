class Solution {
    public int findMaxConsecutiveOnes(int[] nums){
        int res = 0, curr = 0;
        for(int num : nums){
            if(num == 1){
                curr++;
                if(curr > res){
                    res = curr;
                }
            } else{
                curr = 0;
            }
        }
        return res;
    }
}