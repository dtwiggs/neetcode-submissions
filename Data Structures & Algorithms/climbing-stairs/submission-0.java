class Solution {
    

    public int climbStairs(int n){
        return climbStairsRec(n, 0);
    }

    private static int climbStairsRec(int n, int total){
        if (n == 0){   
            total = 1;
        } else if (n == 1){
            total = 1;
        } else {
            total = climbStairsRec(n - 1, total) + climbStairsRec(n - 2, total);
        }

        return total;
    }

}
