class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char tmp;
        for(int i = 0; i < s.length(); i++){
            tmp = s.charAt(i);

            if(tmp == '}' && (stack.isEmpty() || stack.pop() != '{')){
                return false;
            } else if(tmp == ']' && (stack.isEmpty() || stack.pop() != '[')){
                return false;
            } else if(tmp == ')' && (stack.isEmpty() || stack.pop() != '(')){
                return false;
            } else if(tmp == '[' || tmp == '(' || tmp == '{'){
                stack.add(tmp);
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }
}
