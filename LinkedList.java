public class LinkedList {
    
    // Inner Node class
    private static class Node {
        BikeTrip trip;
        Node next;

        Node(BikeTrip trip) {
            this.trip = trip;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // 1. Insert a new trip at the end of the list
    public void insert(BikeTrip trip) {
        Node newNode = new Node(trip);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // 2. Search for a trip by its ID
    public BikeTrip search(String tripId) {
        Node current = head;
        while (current != null) {
            if (current.trip.getTripId().equals(tripId)) {
                return current.trip;
            }
            current = current.next;
        }
        return null; // Not found
    }

    // 3. Delete a trip by its ID
    public boolean delete(String tripId) {
        if (head == null) return false;

        // If head is the one to delete
        if (head.trip.getTripId().equals(tripId)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.trip.getTripId().equals(tripId)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false; // Not found
    }

    // 4. Traverse and print/process all items
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.trip);
            current = current.next;
        }
    }

    public int size() {
        return size;
    }
}
