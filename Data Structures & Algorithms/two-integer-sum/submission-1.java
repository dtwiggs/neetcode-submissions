class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        int[] resA = new int[2];
        for(int i = 1; i < nums.length; i++){
            sums.put(nums[i - 1], i - 1);
            if(sums.get(target - nums[i]) != null){
                resA[0] = sums.get(target - nums[i]);
                resA[1] = i;
            }
        }
        return resA;
    }
}
