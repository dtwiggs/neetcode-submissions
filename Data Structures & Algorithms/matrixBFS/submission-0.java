class Solution {
    public int shortestPath(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        
        if(grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1){
            return -1;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 0));

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int r = curr.r, c = curr.c, depth = curr.depth;
            if(r == rows - 1 && c == cols - 1 && grid[r][c] == 0){
                return depth;
            }

            if(c + 1 < cols && grid[r][c + 1] == 0){
                queue.add(new Pair(r, c + 1, depth + 1));
            }
            if(r + 1 < rows && grid[r + 1][c] == 0){
                queue.add(new Pair(r + 1, c, depth + 1));
            }
        }
        
        return -1;
    }

    class Pair{
        int r;
        int c;
        int depth;
        Pair(int r, int c, int depth){
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
}

/*

grid[][]
0 good
1 bad

shortest path
top left to bottom right
no diagonal

*/