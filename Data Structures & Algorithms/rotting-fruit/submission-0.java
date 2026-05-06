class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, count = 0, min = 1;
        Queue<Pair> queue = new LinkedList<>();

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    count++;
                } else if(grid[r][c] == 2){
                    queue.add(new Pair(r, c, 1));
                }
            }
        }

        if(count == 0){
            return 0;
        }

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int r = curr.row, c = curr.col;
            min = curr.min;

            if(r + 1 < rows && grid[r + 1][c] == 1){
                grid[r + 1][c] = 2;
                queue.add(new Pair(r + 1, c, min + 1));
                count--;
            }
            if(r - 1 >= 0 && grid[r - 1][c] == 1){
                grid[r - 1][c] = 2;
                queue.add(new Pair(r - 1, c, min + 1));
                count--;
            }
            if(c + 1 < cols && grid[r][c + 1] == 1){
                grid[r][c + 1] = 2;
                queue.add(new Pair(r, c + 1, min + 1));
                count--;
            }
            if(c - 1 >= 0 && grid[r][c - 1] == 1){
                grid[r][c - 1] = 2;
                queue.add(new Pair(r, c - 1, min + 1));
                count--;
            }

            if(count == 0){
                return min;
            }
        }

        if(count == 0){
            return min;
        }
        return -1;
    }

    class Pair{
        int row;
        int col;
        int min;
        Pair(int row, int col, int min){
            this.row = row;
            this.col = col;
            this.min = min;
        }
    }
}


/*
BFS from every single rotting fruit
Keep trackers if they overlap, just skip the overlapped fruit.

Stop when the counter of checked cells hits the total number of fruits.

Get a count of all the fresh fruit.
If 0, return 0.
*/