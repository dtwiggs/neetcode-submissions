class Solution {
    public int maxArea(int[] heights) {
        int lf = 0; int rt = heights.length - 1;
        int res = 0, max = 0;

        while(lf < rt){
            int dist = rt - lf;
            max = Math.min(heights[lf], heights[rt]) * dist;
            if(max > res){
                res = max;
            }

            if(heights[lf] < heights[rt]){
                lf++;
            } else{
                rt--;
            }
        }

        return res;
    }
}