class DynamicArray {

    private ArrayList<Integer> ArrLi;
    private int size;
    private int capacity;

    public DynamicArray(int capacity) {
        if (capacity > 0) {
            ArrLi = new ArrayList(capacity);
            this.size = 0;
            this.capacity = capacity;
        }
    }

    public int get(int i) {
        return ArrLi.get(i);
    }

    public void set(int i, int n) {
        ArrLi.set(i, n);
    }

    public void pushback(int n) {
        if(size >= capacity){
            resize();
        }
        ArrLi.add(size, n);
        size++;
    }

    public int popback() {
        int lastNum = ArrLi.get(size - 1);
        ArrLi.remove(size - 1);
        size--;
        return lastNum;
    }

    private void resize() {
        capacity = capacity * 2;
        ArrLi.ensureCapacity(capacity);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
