class Solution {
    public int[] replaceElements(int[] arr){
        int size = arr.length;
        int max = -1;
        int[] res = new int[size];

        for(int i = size - 1; i > -1; i--){
            res[i] = max;
            max = Math.max(max, arr[i]);
        }

        return res;
    }
}