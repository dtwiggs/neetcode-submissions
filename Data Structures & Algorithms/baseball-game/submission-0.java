class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length, curr = 0, score = 0;
        Stack<Integer> res = new Stack<>();

        for(int i = 0; i < n; i++){
            if(operations[i].equals("+")){
                res.add(res.peek() + res.get(res.size() - 2));
            } else if(operations[i].equals("D")){
                res.add(2 * res.peek());
            } else if(operations[i].equals("C")){
                res.pop();
            } else{
                res.add(Integer.parseInt(operations[i]));
            }
        }

        while(!res.isEmpty()){
            score += res.pop();
        }

        return score;
    }
}