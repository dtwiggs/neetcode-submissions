class Solution {
    public int trap(int[] height){
        if(height.length < 3){
            return 0;
        }
        int total = 0;
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];

        while(l < r){
            if(maxL < maxR || maxL == maxR){
                if(maxL - height[l] > 0){
                    total += maxL - height[l];
                } 
                l++;

                if(maxL < height[l]){
                    maxL = height[l];
                }
            } else{
                if(maxR - height[r] >= 0){
                    total += maxR - height[r];
                }
                r--;
                if(maxR < height[r]){
                    maxR = height[r];
                }
            }
        }

        return total;
    }
}
