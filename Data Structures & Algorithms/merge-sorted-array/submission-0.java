class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = nums1.length, n2 = nums2.length;
        int r1 = n1 - n2 - 1, r2 = n2 - 1;
        n1--;

        while(r1 >= 0 && r2 >= 0){
            if(nums1[r1] >= nums2[r2]){
                nums1[n1] = nums1[r1];
                r1--;
                n1--;
            } else{
                nums1[n1] = nums2[r2];
                r2--;
                n1--;
            }
        }

        if(r1 == -1){
            while(n1 >= 0 && r2 >= 0){
                nums1[n1] = nums2[r2];
                n1--;
                r2--;
            }
        } else{
            while(n1 >= 0 && r1 >= 0){
                nums1[n1] = nums1[r1];
                n1--;
                r1--;
            }
        }
    }
}