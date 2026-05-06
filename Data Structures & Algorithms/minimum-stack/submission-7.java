class MinStack {

    ArrayList<Integer> valList = new ArrayList<Integer>();
    ArrayList<Integer> minList = new ArrayList<Integer>();
    Integer min = 2147483647;

    public MinStack() {
        valList.ensureCapacity(10);
        minList.ensureCapacity(10);
    }
    
    public void push(int val) {
        valList.add(val);

        if (val < min){
            min = val;
        }

        minList.add(min);
    }
    
    public void pop() {
        valList.remove(valList.size() - 1);
        minList.remove(minList.size() - 1);

        if (minList.size() > 0){
            min = minList.get(minList.size() - 1);
        } else {
            min = 2147483647;
        }
    }
    
    public int top() {
        return valList.get(valList.size() - 1);
    }
    
    public int getMin() {
        return minList.get(minList.size() - 1);
    }
}