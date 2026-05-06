class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];
        int[] currRow = new int[n];
        prevRow[n - 1] = 1;
        currRow[n - 1] = 1;

        for(int r = m - 1; r >= 0; r--){
            for(int c = n - 1; c >= 0; c--){
                if(c == n - 1){
                    currRow[c] = prevRow[c];
                } else{
                    currRow[c] = prevRow[c] + currRow[c + 1];
                }
            }
            prevRow = currRow;
        }

        return currRow[0];
    }
}
