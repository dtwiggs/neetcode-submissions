class Solution {
    HashMap<Character, Character> matchParen = new HashMap<>();
    ArrayList<Character> a = new ArrayList<>();

    public boolean isValid(String s){

        matchParen.put(']', '[');
        matchParen.put(')', '(');
        matchParen.put('}', '{');
        int j = -1;
        boolean result = true;

        for(int i = 0; i < s.length(); i++){
            if(matchParen.containsValue(s.charAt(i))){
                a.add(s.charAt(i));
                j++;
            } else if (matchParen.containsKey(s.charAt(i))){
                if(j == -1){
                    System.out.println("No open parentheses prior to a close");
                    result = false;
                } else if(matchParen.get(s.charAt(i)) == a.get(j)){
                    a.remove(j);
                    j--;
                } else{
                    System.out.println("Close did not match last open");
                    result = false;
                }
            } else {
                System.out.println("Character not a parantheses");
                result = false;
            }
        }

        if(a.size() == 0 && result != false){
            result = true;
        } else {
            result = false;
        }

        return result;
    }

}