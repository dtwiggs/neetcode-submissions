class Solution {
    public boolean isPalindrome(String s) {
        int lf = 0, rt = s.length() - 1;
        while(lf < rt){
            while(lf < rt && !check(s.charAt(lf))){
                lf++;
            }
            while(lf < rt && !check(s.charAt(rt))){
                rt--;
            }

            if(Character.toLowerCase(s.charAt(lf)) != Character.toLowerCase(s.charAt(rt))){
                return false;
            }
            lf++;
            rt--;
        }

        return true;
    }

    public boolean check(Character a){
        if(a >= 48 && a <= 57){
            return true;
        } if(a >= 65 && a <= 90){
            return true;
        } else if(a >= 97 && a <= 122){
            return true;
        }

        return false;
    }
}