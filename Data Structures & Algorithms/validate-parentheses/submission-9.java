class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> parenMap = new HashMap<>();
        parenMap.put('}', '{');
        parenMap.put(']', '[');
        parenMap.put(')', '(');

        Stack<Character> stack = new Stack<>();

        if(s.length()%2 == 1){
            return false;
        } else{
            for(int i = 0; i < s.length(); i++){
                if(parenMap.containsKey(s.charAt(i)) && stack.size() > 0){
                    if (parenMap.get(s.charAt(i)) == stack.peek()){
                        stack.pop();
                    } else{
                        return false;
                    }
                } else if(parenMap.containsKey(s.charAt(i)) && stack.size() == 0){
                    return false;
                } else{
                    stack.add(s.charAt(i));
                }
            }
            if (stack.size() == 0){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
