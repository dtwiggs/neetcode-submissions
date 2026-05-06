class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }

        return binSearch(nums, target, 0, nums.length - 1);
    }

    private int binSearch(int[] arr, int target, int l, int r){
        int mid = (r - l) / 2 + l;
        if(l >= r){
            if(arr[mid] == target){
                return mid;
            }
            return -1;
        } 

        if(arr[mid] < target){
            return binSearch(arr, target, mid + 1, r);
        } else{
            return binSearch(arr, target, l, mid);
        }
    }
}
