class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int sum, j, k;

        if(nums.length < 3){
            return res;
        }

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            j = i + 1;
            k = nums.length - 1;
            while (j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                } else if(sum > 0){
                    k--;
                } else{
                    if(res.isEmpty()){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    } else if((nums[j] != nums[j - 1] || j - 1 == i) && (k == nums.length - 1 || nums[k] != nums[k + 1])){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    j++;
                }
            }
        }

        return res;
    }
}
