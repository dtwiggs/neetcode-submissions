class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0], currMax = 0, minSum = nums[0], currMin = 0, total = 0;

        for(int r = 0; r < nums.length; r++){
            if(currMax < 0) currMax = 0;
            if(currMin > 0) currMin = 0;

            currMax += nums[r];
            currMin += nums[r];
            total += nums[r];

            if(currMax > maxSum) maxSum = currMax;
            if(currMin < minSum) minSum = currMin;
        }
        System.out.println(currMax);
        System.out.println(maxSum);
        System.out.println(currMin);
        System.out.println(minSum);
        System.out.println(total);
        System.out.println(total - minSum);
        if(maxSum > 0){
            maxSum = Math.max(maxSum, total - minSum);
        }

        return maxSum;
    }
}