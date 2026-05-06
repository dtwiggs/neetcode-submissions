class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }

        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int res = 1;
        int lf = 0;

        for(int i = 1; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            } else{


                if(map.get(s.charAt(i)) < lf){
                    map.put(s.charAt(i), i);
                } else{
                    if(res < i - lf){
                        res = i - lf;
                    }
                    lf = map.get(s.charAt(i)) + 1;
                    map.put(s.charAt(i), i);
                }
            }
        }

        if(res < s.length() - lf){
            res = s.length() - lf;
        }
        return res;
    }
}
