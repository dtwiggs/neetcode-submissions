class Solution {
    int rows, cols;
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        rows = matrix.length;
        cols = matrix[0].length;

        return binSearch(matrix, target, new Pair(0, 0), new Pair(rows - 1, cols - 1));
    }

    private boolean binSearch(int[][] matrix, int target, Pair l, Pair r){
        if (l.abs > r.abs){
            return false;
        }

        Pair midPair = new Pair((r.abs - l.abs) / 2 + l.abs);
        int val = matrix[midPair.r][midPair.c];
        
        if(val == target){
            return true;
        } else if(val < target){
            return binSearch(matrix, target, new Pair(midPair.abs + 1), r);
        } else{
            return binSearch(matrix, target, l, new Pair(midPair.abs - 1));
        }
    }

    public class Pair{
        int r, c, abs;

        Pair() {}
        Pair(int r, int c) { 
            this.r = r; 
            this.c = c; 
            this.abs = cols * r + c;
        }
        Pair(int abs){
            this.r = abs / cols; 
            this.c = abs % cols;
            this.abs = abs;
        }
    }
}
