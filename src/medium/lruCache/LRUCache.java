package medium.lruCache;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {
    Map<Integer, Node> map;
    Node left;
    Node right;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.left = new Node(0, 0);
        this.left.next = right;
        this.right = new Node(0, 0);
        this.right.prev = left;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node curr = map.get(key);
        remove(curr);
        insert(curr);
        return curr.value;
    }

    public void insert(Node node) {
        Node prev = this.right.prev;
        this.right.prev = node;
        node.prev = prev;
        node.next = this.right;
        prev.next = node;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            n.value = value;
            insert(n);
        } else {
            Node n = new Node(key, value);
            map.put(key, n);
            insert(n);
        }

        if (map.size() > capacity) {
            Node leftMost = left.next;
            remove(leftMost);
            map.remove(leftMost.key);
        }
    }
}
