class Solution {
    HashMap<Character, Integer> map = new HashMap<>();

    public boolean isAnagram(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() != t.length()){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            if(map.isEmpty()){
                map.put(s.charAt(i), 1);
            } else if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else{
                map.put(s.charAt(i), 1);
            }
        }

        for(int i = 0; i < t.length(); i++){
            if(!map.containsKey(t.charAt(i))){
                return false;
            } else if(map.get(t.charAt(i)) == 0){
                return false;
            } else if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }

        return true;
    }
}
