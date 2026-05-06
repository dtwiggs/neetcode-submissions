class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    void push(int val){
        stack.push(val);

        if(minStack.isEmpty()){
            minStack.push(val);
        } else if(val < minStack.peek()){
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    void pop(){
        stack.pop();
        minStack.pop();
    }

    int top(){
        return stack.peek();
    }

    int getMin(){
        return minStack.peek();
    }

}