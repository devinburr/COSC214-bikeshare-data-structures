public class HashTable {

    private static class Node {
        String key;
        BikeTrip value;
        Node next;

        Node(String key, BikeTrip value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node[] buckets;
    private int size;

    public HashTable(int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    public HashTable() {
        this(10007); // Default prime capacity
    }

    private int getIndex(String key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // 1. INSERT
    public void insert(String key, BikeTrip value) {
        int index = getIndex(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        buckets[index] = new Node(key, value, buckets[index]);
        size++;
    }

    // 2. SEARCH
    public BikeTrip search(String key) {
        int index = getIndex(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    // 3. DELETE
    public boolean delete(String key) {
        int index = getIndex(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    // 4. TRAVERSE
    public void traverse() {
        for (int i = 0; i < buckets.length; i++) {
            Node current = buckets[i];
            while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }
    }

    public int size() {
        return size;
    }
}

