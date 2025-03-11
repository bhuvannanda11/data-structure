import java.util.*;

public class CustomHashMap<K, V> {
    // Define the default size of the hash map (initial capacity)
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Node<K, V>>[] table;
    private int size;

    // Node class to represent key-value pairs
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the hash map with the default capacity
    public CustomHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        size = 0;

        // Initialize each slot in the table with an empty linked list
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to determine the index in the array
    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % table.length;
    }

    // Put operation: Insert or update the key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Check if key already exists in the linked list at this index
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; // Update the value
                return;
            }
        }

        // If key does not exist, create a new node and add it to the list
        bucket.add(new Node<>(key, value));
        size++;

        // Optionally, resize the table if the load factor exceeds a threshold
        if (size > table.length * 0.75) {
            resize();
        }
    }

    // Get operation: Retrieve the value for a given key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Search for the key in the corresponding linked list
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value; // Return the value if found
            }
        }

        return null; // Return null if the key does not exist
    }

    // Remove operation: Delete the key-value pair for a given key
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Search for the key in the linked list and remove it
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node); // Remove the node from the list
                size--;
                return;
            }
        }
    }

    // Resize the hash map when the load factor exceeds a threshold
    private void resize() {
        // Double the size of the table
        LinkedList<Node<K, V>>[] oldTable = table;
        table = new LinkedList[oldTable.length * 2];
        size = 0;

        // Rehash all existing key-value pairs to the new table
        for (LinkedList<Node<K, V>> bucket : oldTable) {
            for (Node<K, V> node : bucket) {
                put(node.key, node.value);
            }
        }
    }

    // Get the current size of the hash map
    public int size() {
        return size;
    }

    // Check if the hash map is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Main function to test the custom hash map implementation
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Insert key-value pairs into the map
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        // Retrieve values
        System.out.println("apple: " + map.get("apple"));  // Output: 10
        System.out.println("banana: " + map.get("banana")); // Output: 20

        // Update value for key "banana"
        map.put("banana", 25);
        System.out.println("Updated banana: " + map.get("banana")); // Output: 25

        // Remove a key-value pair
        map.remove("apple");
        System.out.println("apple after removal: " + map.get("apple")); // Output: null

        // Print the size of the hash map
        System.out.println("Size of the map: " + map.size()); // Output: 2
    }
}
