class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2){
            return n;
        } else{
            return climbStairsRec(n);
        }        
    }

    private static int climbStairsRec(int n){
        int total;
        if(n == 1 || n == 2){
            return n;
        } else{
            total = climbStairsRec(n - 1) + climbStairsRec(n - 2);
        }
        return total;
    }
}
