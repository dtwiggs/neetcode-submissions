class Solution {
    public int findDuplicate(int[] nums) {
        int curr = -1, tmp = -1;
        
        for(int i = 0; i < nums.length; i++){
            curr = nums[i];
            if(curr == i + 1){
                continue;
            } else if(curr == nums[curr - 1]){
                return curr;
            }

            while(tmp != nums[curr - 1]){
                tmp = nums[curr - 1];
                nums[curr - 1] = curr;
                curr = tmp;
            }
            tmp = -1;
        }

        return curr;
    }
}
