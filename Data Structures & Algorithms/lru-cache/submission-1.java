class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int capacity;
    int size;
    Map<Integer, Node> cache; 

    // dummy pointers to linked list 
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        int size = 0;
        this.cache = new HashMap<>();
        this.head = new Node(-1, 0);
        this.tail = new Node(-1, 0);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void insert(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        tail.prev = node;
        node.next = tail;
        node.prev = prev;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            size--;
        } 
        
        if (size == capacity) {
            cache.remove(head.next.key);
            remove(head.next);
            size--;
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);
        size++;
    }
}
