public class DynamicArray {
    private BikeTrip[] trips;
    private int size;

    // Constructor
    public DynamicArray() {
        trips = new BikeTrip[10];
        size = 0;
    }

    // Insert
    public void insert(BikeTrip trip) {
        if (size == trips.length) {
            resize();
        }

        trips[size] = trip;
        size++;
    }

    // Resize
    private void resize() {
        BikeTrip[] newArray = new BikeTrip[trips.length * 2];

        for (int i = 0; i < size; i++) {
            newArray[i] = trips[i];
        }

        trips = newArray;
    }

    // Search
    public BikeTrip search(String id) {
        for (int i = 0; i < size; i++) {
            if (trips[i].rideId.equals(id)) {
                return trips[i];
            }
        }

        return null;
    }

    // Delete
    public boolean delete(String id) {
        for (int i = 0; i < size; i++) {
            if (trips[i].rideId.equals(id)) {

                for (int j = i; j < size - 1; j++) {
                    trips[j] = trips[j + 1];
                }

                size--;
                trips[size] = null;
                return true;
            }
        }

        return false;
    }

    // Traverse
    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(trips[i].rideId);
        }
    }
    // Size
    public int size() {
        return size;
    }
}
