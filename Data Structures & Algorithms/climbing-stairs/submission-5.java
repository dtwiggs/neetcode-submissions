class Solution {
    public int climbStairs(int n) {
        if(n <= 3){
            return n;
        }

        return climbStairsRec(n, 0, 0);
    }  

    private int climbStairsRec(int n, int i, int res){
        if(i == n){
            res++;
            return res;
        } else if(i > n){
            return res;
        }

        res = climbStairsRec(n, i + 1, res) + climbStairsRec(n, i + 2, res);
        return res;
    }
}