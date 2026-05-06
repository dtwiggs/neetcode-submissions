class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1){
            return new int[] {0};
        }

        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
                int[] tmp = stack.pop();
                res[tmp[1]] = i - tmp[1];
            }

            stack.add(new int[] {temperatures[i], i});
        }

        return res;
    }
}
