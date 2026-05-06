class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 == 1 || s.length() == 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp == '{' || tmp == '[' || tmp == '('){
                stack.add(tmp);
            } else{
                if(stack.isEmpty()){
                    return false;
                }
                
                char top = stack.pop();
                if(tmp == '}' && top != '{'){
                    return false;
                } else if(tmp == ']' && top != '['){
                    return false;
                } else if(tmp == ')' && top != '('){
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
