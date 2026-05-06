class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> rows = new HashMap<>();
        HashMap<Integer, Set<Character>> cols = new HashMap<>();
        HashMap<String, Set<Character>> squares = new HashMap<>();
        String square;
        char num;

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                square = (r / 3) + "," + (c / 3);
                num = board[r][c];

                if(board[r][c] == '.'){
                    continue;
                }

                rows.putIfAbsent(r, new HashSet<>());
                cols.putIfAbsent(c, new HashSet<>());
                squares.putIfAbsent(square, new HashSet<>());

                if (rows.get(r).contains(num) || cols.get(c).contains(num) || squares.get(square).contains(num)) {
                    return false;
                }

                rows.get(r).add(num);
                cols.get(c).add(num);
                squares.get(square).add(num);
            }
        }
        return true;
    }
}
