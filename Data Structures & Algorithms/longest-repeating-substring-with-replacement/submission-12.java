class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, kay = k, next = 0, start = 0, startK = 0, max = 1;
        char curr = s.charAt(i);

        while(j < s.length() - 1){
            j++;

            if(curr != s.charAt(j)){
                if(kay > 0){
                    if(kay == k){
                        next = j;
                    }
                    kay--;
                } else if(k == 0){
                    i = j;
                    curr = s.charAt(i);
                    continue;
                } else{
                    i = next;
                    j = next;
                    curr = s.charAt(next);
                    kay = k;
                    continue;
                }
            }

            if(j - i  + 1 >= max){
                max = j - i + 1;
                start = i;
                startK = kay;
            }
        }

        while(startK > 0 && start > 0){
            startK--;
            start--;
            max++;
        }

        return max;
    }
}