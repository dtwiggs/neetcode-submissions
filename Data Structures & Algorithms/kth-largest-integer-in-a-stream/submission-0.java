class KthLargest {
    private ArrayList<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums){
        heap = new ArrayList<>();
        this.k = k;

        for(int i = 0; i < nums.length; i++){
            push(nums[i]);
        }
    }

    public int add(int val) {
        push(val);
        return peek();
    }

    public void push(int val){
        if(heap.size() == 0){
            heap.add(val);
        } else if(heap.size() < k){
            heap.add(val);
            int childIndex = heap.size() - 1;
            while(val < heap.get(childIndex / 2)){
                heap.set(childIndex, heap.get(childIndex / 2));
                heap.set(childIndex / 2, val);
                childIndex = childIndex / 2;
            }
        } else if(val > peek()){
            pop();
            heap.add(val);
            int childIndex = heap.size() - 1;
            while(val < heap.get(childIndex / 2)){
                heap.set(childIndex, heap.get(childIndex / 2));
                heap.set(childIndex / 2, val);
                childIndex = childIndex / 2;
            }
        }
    }

    public int peek(){
        return heap.get(0);
    }

    public int pop(){
        int top = heap.get(0);
        int childIndex = 1;
        int tmp;

        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        while(childIndex < heap.size()){
            if((childIndex + 1) < heap.size() 
                && heap.get(childIndex + 1) < heap.get(childIndex) 
                && heap.get(childIndex / 2) > heap.get(childIndex + 1)){
                
                tmp = heap.get(childIndex / 2);
                heap.set((childIndex / 2), heap.get(childIndex + 1));
                heap.set(childIndex + 1, tmp);
                childIndex *= 2;
            } else if(heap.get(childIndex / 2) > heap.get(childIndex)){
                tmp = heap.get(childIndex / 2);
                heap.set((childIndex / 2), heap.get(childIndex));
                heap.set(childIndex, tmp);
                childIndex *= 2;
            } else{
                break;
            }
        }
        return top;
    }
}