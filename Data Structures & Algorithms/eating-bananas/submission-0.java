class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;

        if(piles.length == 1){
            min = (piles[0] + h - 1) / h;
        }
        else {
            int max = piles[0];
            for(int i = 0; i < piles.length; i++){
                if(piles[i] > max){
                    max = piles[i];
                }
            }
            min = binarySearchRec(piles, h, 1, max);
        }
        return min;
    } 

    private static int binarySearchRec(int[] bananas, int h, int l, int r){
        int min = r;

        if(l > r){
            return l;
        }

        int i = 0;
        int temp = 0;
        int mid = l + (r - l) / 2;
        while (i < bananas.length && temp < h){
            temp += (bananas[i] + mid - 1)/mid;
            i++;
        }
        
        if(i == bananas.length && temp == h){
            min = mid;
        } else if(i == bananas.length && temp < h){
            min = binarySearchRec(bananas, h, l, mid - 1);
        } else if(i < bananas.length || temp > h){
            min = binarySearchRec(bananas, h, mid + 1, r);
        }
        return min;
    }
}
