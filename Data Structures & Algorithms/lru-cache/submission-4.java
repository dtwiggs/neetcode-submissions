class LRUCache {
    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> removed;
    Queue<Integer> queue;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        removed = new HashMap<>();
        queue = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.isEmpty() || !map.containsKey(key)){
            return -1;
        } else{
            queue.add(key);
            removed.put(key, removed.getOrDefault(key, 0) + 1);
            return map.get(key);
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            removed.put(key, removed.getOrDefault(key, 0) + 1);
            map.put(key, value);
            queue.add(key);
        } else if(!map.containsKey(key) && map.size() == capacity){
            int tmp = queue.poll();
            while(removed.getOrDefault(tmp, 0) > 0){
                removed.put(tmp, removed.get(tmp) - 1);
                tmp = queue.poll();
            }
            map.remove(tmp);
            map.put(key, value);
            queue.add(key);
        } else{
            map.put(key, value);
            queue.add(key);
        }
    }
}