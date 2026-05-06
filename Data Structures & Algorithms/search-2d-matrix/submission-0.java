class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean test = false;
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        } else{
            test = searchMatrixRec(matrix, 0, matrix.length * matrix[0].length - 1, target);
        }
        return test;
    }

    private boolean searchMatrixRec(int[][] m, int s, int e, int target){

        boolean test = false;
        int mid = s + (e - s)/2;
        int row = mid / m[0].length;
        int col = mid % m[0].length;
        
        if(s > e){
        } else if(target == m[row][col]){
            test = true;
        } else if(target < m[row][col]){
            test = searchMatrixRec(m, s, mid - 1, target);
        } else if(target > m[row][col]){
            test = searchMatrixRec(m, mid + 1, e, target);
        }

        return test;
    }
}
