class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<Character> stack = new Stack<>();
        List<String>res = new ArrayList<>();
        genParenRec(n, stack, res, 0, 0);

        return res;
    }

    public void genParenRec(int n, Stack<Character> stack, List<String> res, int lf, int rt) {
        if(stack.size() == 2 * n && lf == rt){
            StringBuilder str = new StringBuilder(2 * n);
            for(int i = 0; i < stack.size(); i++){
                str.append(stack.elementAt(i));
            }
            res.add(str.toString());
            return;
        }

        if(lf < n){
            stack.add('(');
            genParenRec(n, stack, res, lf + 1, rt);
            stack.pop();
        }

        if(rt < lf){
            stack.add(')');
            genParenRec(n, stack, res, lf, rt + 1);
            stack.pop();
        }
        return;
    }
}
