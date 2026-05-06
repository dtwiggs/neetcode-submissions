class Solution {
    Set<Integer> coords = new HashSet<>();
    int rows;
    int cols;
    int count;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        count = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1' && !coords.contains(r * cols + c)){
                    numIslandsRec(grid, r, c, coords);
                    count++;
                }
            }
        }

        return count;
    }

    public void numIslandsRec(char[][] grid, int r, int c, Set<Integer> coords) {
        int index = r * cols + c;

        if(coords.contains(index) || grid[r][c] == 0){
        } else{
            coords.add(index);
            if(r - 1 >= 0 && !coords.contains(index - cols) && grid[r - 1][c] == '1'){
                numIslandsRec(grid, r - 1, c, coords);
            }
            if(r + 1 < rows && !coords.contains(index + cols) && grid[r + 1][c] == '1'){
                numIslandsRec(grid, r + 1, c, coords);
            }
            if(c - 1 >= 0 && !coords.contains(index - 1) && grid[r][c - 1] == '1'){
                numIslandsRec(grid, r, c - 1, coords);
            }
            if(c + 1 < cols && !coords.contains(index + 1) && grid[r][c + 1] == '1'){
                numIslandsRec(grid, r, c + 1, coords);
            }
        }
    }
}