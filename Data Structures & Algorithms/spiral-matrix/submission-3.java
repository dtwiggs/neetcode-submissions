class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> res = new ArrayList<>(rows * cols);

        int minR = 0, maxR = rows - 1, minC = 0, maxC = cols - 1, r = 0, c = 0, side = 1;
        for(int i = 0; i < rows * cols; i++){
            res.add(matrix[r][c]);

            if(side % 4 == 1){
                if(c < maxC){
                    c++;
                } else {
                    minR++;
                    r++;
                    side++;
                }
            } else if(side % 4 == 2){
                if(r < maxR){
                    r++;
                } else {
                    maxC--;
                    c--;
                    side++;;
                }
            } else if(side % 4 == 3){
                if(c > minC){
                    c--;
                } else {
                    maxR--;
                    r--;
                    side++;;
                }
            } else if(side % 4 == 0){
                if(r > minR){
                    r--;
                } else {
                    minC++;
                    c++;
                    side++;;
                }
            } 
        }
        
        return res;
    }
}