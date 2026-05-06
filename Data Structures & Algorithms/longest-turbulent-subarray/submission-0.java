class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int j = 0, max = 1, currMax = 1, curr = arr[j], last = 0;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[j]){
                if(last == -1){
                    currMax = 1;
                }
                last = -1;
            } else if(arr[i] > arr[j]){
                if(last == 1){
                    currMax = 1;
                }
                last = 1;
            } else{
                last = 0;
                currMax = 0;
            }
            currMax++;

            if(currMax > max){
                max = currMax;
            }
            j++;
        }

        return max;
    }
}