class HashTable {
    Node[] a;
    int capacity;
    int size;

    public HashTable(int capacity) {
        a = new Node[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public void insert(int key, int value) {
        int idx = hash(key);
        Node tmp = a[idx];

        if(tmp == null){
            a[idx] = new Node(key, value);
            size++;
        } else if(a[idx].key == key){
            a[idx].value = value;
        } else{
            while(tmp.next != null && tmp.next.key != key){
                tmp = tmp.next;
            }

            if(tmp.next == null){
                tmp.next = new Node(key, value);
                size++;
            } else{
                tmp.next.value = value;
            }
        }

        if(size >= capacity / 2){
            resize();
        }
    }

    public int get(int key) {
        Node tmp = a[hash(key)];

        if(tmp == null){
            return -1;
        }

        while(tmp.key != key && tmp.next != null){
            tmp = tmp.next;
        }

        if(tmp.key == key){
            return tmp.value;
        } else{
            return -1;
        }
    }

    public boolean remove(int key) {
        int idx = hash(key);
        Node tmp = a[idx];

        if(tmp == null){
            return false;
        } else if(tmp.key == key){
            if(tmp.next == null){
                a[idx] = null;
                size--;
                return true;
            } else{
                a[idx] = tmp.next;
                size--;
                return true;
            }
        }

        while(tmp.next != null && tmp.next.key != key){
            tmp = tmp.next;
        }

        if(tmp.next == null){
            return false;
        } else{
            if(tmp.next.next == null){
                tmp.next = null;
                size--;
                return true;
            } else{
                tmp.next = tmp.next.next;
                size--;
                return true;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resize() {
        Node[] tmpA = a;
        Node tmpN;
        capacity *= 2;
        size = 0;
        a = new Node[capacity];
        
        for(int i = 0; i < tmpA.length; i++){
            tmpN = tmpA[i];
            while(tmpN != null){
                insert(tmpN.key, tmpN.value);
                tmpN = tmpN.next;
            }
        }
    }

    public int hash(int key){
        return key % capacity;
    }
}

class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}