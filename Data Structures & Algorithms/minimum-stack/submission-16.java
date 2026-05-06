class MinStack {
    Stack<Integer> myStack;
    HashMap<Integer, Integer> myHash;
    int min = 2147483647;

    MinStack(){
        myStack = new Stack<>();
        myHash = new HashMap<>();
        myHash.put(0, min);
    }

    void push(int val){
        myStack.add(val);
        if(val < min){
            min = val;
        }
        myHash.put(myStack.size(), min);
    }

    void pop(){
        myHash.remove(myStack.size());
        myStack.pop();
        min = getMin();
    }

    int top(){
        return myStack.peek();
    }

    int getMin(){
        return myHash.get(myStack.size());
    }
}