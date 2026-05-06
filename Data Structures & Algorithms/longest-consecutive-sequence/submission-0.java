class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int j, k, longest = 0;

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i] - 1)){
                j = 1;
                k = 1;
                while(set.contains(nums[i] + j)){
                    j++;
                    k++;
                }
                if(k > longest){
                    longest = k;
                }
            }
        }

        return longest;
    }
}
