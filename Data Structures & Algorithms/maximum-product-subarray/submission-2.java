class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int n = nums.length, curr, max = -2147483648;

        for(int i = 0; i < n; i++){
            curr = nums[i];
            for(int j = i + 1; j < n; j++){
                if(curr > max){
                    max = curr;
                }
                curr *= nums[j];
                /*
                if(curr <= curr * nums[j]){
                    curr *= nums[j];
                } else{
                    break;
                }
                */
            }
            if(curr > max){
                max = curr;
            }
        }

        return max;
    }
}
