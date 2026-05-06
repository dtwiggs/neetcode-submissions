class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        HashSet<Integer> targetR = new HashSet<>();
        HashSet<Integer> targetC = new HashSet<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    targetR.add(i);
                    targetC.add(j);
                }
            }
        }

        if(targetR.isEmpty()){
            return;
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(targetR.contains(i) || targetC.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
        return;
    }
}
