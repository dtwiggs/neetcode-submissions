class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int j = heights.length - 1;

        for(int i = 0; i < heights.length; i++){
            if(i >= j){
                break;
            }

            if(heights[i] <= heights[j]){
                if(heights[i] * (j - i) > max){
                    max = heights[i] * (j - i);
                }
            } else{
                if(heights[j] * (j - i) > max){
                    max = heights[j] * (j - i);
                }
            }

            if(heights[i] > heights[j]){
                j--;
                i--;
            }
        }

        return max;
    }
}
