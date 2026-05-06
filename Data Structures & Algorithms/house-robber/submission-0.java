class Solution {
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        int tmp;

        for(int n : nums){
            tmp = Math.max(a + n, b);
            a = b;
            b = tmp;
        }

        return b;
    }
}
