class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length == 1){
            return (piles[0] + h - 1) / h;
        }

        int max = piles[0];
        for(int a : piles){
            if(a > max){
                max = a;
            }
        }

        if(h == piles.length){
            return max;
        }

        return binSearch(piles, h, 1, max);
    }

    private int binSearch(int[] piles, int h, int min, int max){
        int mid = (max - min) / 2 + min;
        int tmp = 0;
        int i = 0;

        if(min > max){
            return min;
        }
        
        while(tmp <= h &&  i < piles.length){
            tmp += (piles[i] + mid - 1)/ mid;
            i++;
        }

        if(tmp == h){
            return mid;
        } else if(min == max && tmp > h){
            mid = min + 1;
        } else if(tmp > h){
            mid = binSearch(piles, h, mid + 1, max);
        } else if(tmp < h){
            mid = binSearch(piles, h, min, mid - 1);
        }

        return mid;
    }
}