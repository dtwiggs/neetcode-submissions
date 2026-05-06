class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean res = false;
        int rows = board.length, cols = board[0].length;
        HashSet<Character> squareLf = new HashSet<>();
        HashSet<Character> squareCn = new HashSet<>();
        HashSet<Character> squareRt = new HashSet<>();

        for(int row = 0; row < rows; row++){
            HashSet<Character> rowSet = new HashSet<>();
            for(int col = 0; col < cols; col++){
                if(board[row][col] == '.'){
                } else if(rowSet.isEmpty() || !rowSet.contains(board[row][col])){
                    rowSet.add(board[row][col]);
                } else{
                    System.out.println("Cols, Exited at row " + row + " and col " + col);
                    return false;
                }

                if(col == 8){
                    System.out.println("Row: " + rowSet);
                }


                if(col < 3){
                    if(board[row][col] == '.'){
                    } else if(squareLf.isEmpty() || !squareLf.contains(board[row][col])){
                        squareLf.add(board[row][col]);
                    } else{
                        System.out.println("Lf, Exited at row " + row + " and col " + col);
                        return false;
                    }
                }
                if(col >= 3 && col < 6){
                    if(board[row][col] == '.'){
                    } else if(squareCn.isEmpty() || !squareCn.contains(board[row][col])){
                        squareCn.add(board[row][col]);
                    } else{
                        System.out.println("Cn,Exited at row " + row + " and col " + col);
                        return false;
                    }
                }
                if(col >= 6 && col < 9){
                    if(board[row][col] == '.'){
                    } else if(squareRt.isEmpty() || !squareRt.contains(board[row][col])){
                        squareRt.add(board[row][col]);
                    } else{
                        System.out.println("Rt, Exited at row " + row + " and col " + col);
                        return false;
                    }
                }

                if(col == 8 && (row + 1) % 3 == 0){
                    System.out.println("Lf square: " + squareLf);
                    System.out.println("Cn square: " + squareCn);
                    System.out.println("Rt square: " + squareRt);
                    squareLf = new HashSet<>();
                    squareCn = new HashSet<>();
                    squareRt = new HashSet<>();
                }
            }
        }

        for(int col = 0; col < cols; col++){
            HashSet<Character> colSet = new HashSet<>();
            for(int row = 0; row < rows; row++){
                if(board[row][col] == '.'){
                } else if(colSet.isEmpty() || !colSet.contains(board[row][col])){
                    colSet.add(board[row][col]);
                } else{
                    System.out.println("Rows, Exited at row " + row + " and col " + col);
                    return false;
                }

                if(row == 8){
                    System.out.println("Col: " + colSet);
                }
            }
        }

        res = true;

        return res;
    }
}