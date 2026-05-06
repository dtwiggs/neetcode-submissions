class Solution {
    public void sortColors(int[] nums) {
        int[] bucket = new int[] {0, 0, 0};

        for(int i = 0; i < nums.length; i++){
            bucket[nums[i]]++;
        }

        int j = 0;
        while(bucket[0] > 0 && j < nums.length){
            bucket[0]--;
            nums[j] = 0;
            j++;
        }
        while(bucket[1] > 0 && j < nums.length){
            bucket[1]--;
            nums[j] = 1;
            j++;
        }
        while(bucket[2] > 0 && j < nums.length){
            bucket[2]--;
            nums[j] = 2;
            j++;
        }
    }
}