class Solution {
    public int climbStairs(int n){
        if(n <= 2){
            return n;
        }

        int[] max = {1, 2};

        for(int i = 3; i <= n; i++){
            int tmp = max[1];
            max[1] = max[0] + max[1];
            max[0] = tmp;
        }

        return max[1];
    }
}
