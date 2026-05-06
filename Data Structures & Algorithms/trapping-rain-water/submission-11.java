class Solution {
    public int trap(int[] height) {
        int lf = 0;
        int rt = height.length - 1;
        int bound = 0;
        int total = 0;

        while(lf < rt){
            if(height[lf] < height[rt]){
                if(bound > height[lf]){
                    total += bound - height[lf];
                } else{
                    bound = height[lf];
                }
                lf++;
            } else{
                if(bound > height[rt]){
                    total += bound - height[rt];
                } else{
                    bound = height[rt];
                }
                rt--;
            }
        }

        return total;
    }
}
