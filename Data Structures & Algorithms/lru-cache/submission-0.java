class LRUCache {
    HashMap<Integer, Integer> map;
    Queue<Integer> queue = new LinkedList<>();
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.isEmpty() || !map.containsKey(key)){
            return -1;
        } else{
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key) && map.size() == capacity){
            map.remove(queue.poll());
            map.put(key, value);
        } else if(map.containsKey(key)){
            queue.remove(key);
            map.put(key, value);
            queue.add(key);
        } else{
            map.put(key, value);
            queue.add(key);
        }
    }
}