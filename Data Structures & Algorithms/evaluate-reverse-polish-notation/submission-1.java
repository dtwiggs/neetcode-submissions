class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            int tmp;
            int lf;
            int rt;
            if(tokens[i].equals("+")){
                rt = stack.pop();
                lf = stack.pop();
                tmp = lf + rt;
                stack.add(tmp);
            } else if(tokens[i].equals("-")){
                rt = stack.pop();
                lf = stack.pop();
                tmp = lf - rt;
                stack.add(tmp);
            } else if(tokens[i].equals("*")){
                rt = stack.pop();
                lf = stack.pop();
                tmp = lf * rt;
                stack.add(tmp);
            } else if(tokens[i].equals("/")){
                rt = stack.pop();
                lf = stack.pop();
                tmp = lf / rt;
                stack.add(tmp);
            } else{
                stack.add(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
