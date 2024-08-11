// https://leetcode.com/problems/lru-cache/description/


class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = val;  // Update the val
            remove(node);        // Remove the node from its current position
            add(node);           // Move the node to the front (most recently used)
        } else {
            if (cache.size() >= capacity) {
                // Remove the least recently used node (node before tail)
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }
            // Create a new node and add it to the front
            Node newNode = new Node(key, val);
            cache.put(key, newNode);
            add(newNode);
        }
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void add(Node node){
        // put after head Node
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,val);
 */