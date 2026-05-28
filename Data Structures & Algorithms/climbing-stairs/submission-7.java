class Solution {
    public int climbStairs(int n){
        if(n == 0 || n == 1 || n == 2 || n == 3){
            return n;
        }

        int[] res = {2, 1, 0};
        for(int i = 3; i <= n; i++){
            res[2] = res[1];
            res[1] = res[0];
            res[0] = res[1] + res[2];
        }

        return res[0];
    }
}
