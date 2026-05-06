class Solution {
    public int[] replaceElements(int[] arr) {
        int size = arr.length;
        int max = arr[size - 1];
        int[] res = new int[size];
        res[size - 1] = -1;

        for(int i = size - 1; i > 0; i--){
            max = Math.max(max, arr[i]);
            res[i - 1] = max;
        }

        return res;
    }
}