class Solution{
    public int search(int[] a, int targetVal){
        int index = -1;

        if(a.length > 0){
            index = binarySearchRec(a, 0, a.length - 1, targetVal);
        }

        return index;
    }

    private static int binarySearchRec(int[] a, int l, int r, int targetVal){
        int index = -1;
        int mid = l + (r - l) / 2;
        
        if(l > r){
        } else if(targetVal == a[mid]){
            index = mid;
        } else if(targetVal < a[mid]){
            index = binarySearchRec(a, l, mid - 1, targetVal);
        } else if(targetVal > a[mid]){
            index = binarySearchRec(a, mid + 1, r, targetVal);
        }
        return index;
    }
}