import java.util.*;
// Item class representing an inventory item node in the singly linked list
class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    // Constructor to initialize item details
    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// InventoryManagementSystem class to manage inventory using singly linked list
class InventoryManagementSystem {
    Item head;

    // Constructor to initialize the inventory (empty list)
    public InventoryManagementSystem() {
        this.head = null;
    }

    // Add an item at the beginning of the list
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end of the list
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // Add an item at a specific position in the list
    public void addItemAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        Item newItem = new Item(itemName, itemId, quantity, price);

        if (position == 0) {
            addItemAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        Item temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove an item by Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // If the item to be removed is at the head
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null) {
            if (temp.next.itemId == itemId) {
                temp.next = temp.next.next;
                System.out.println("Item with ID " + itemId + " removed.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Update the quantity of an item by Item ID
    public void updateItemQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity of Item with ID " + itemId + " updated to " + newQuantity);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID
    public void searchItemById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item Name
    public void searchItemByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with Name " + itemName + " not found.");
    }

    // Calculate and display the total value of the inventory
    public void calculateTotalInventoryValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Sort the inventory based on Item Name (ascending or descending)
    public void sortInventoryByName(boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("No items to sort.");
            return;
        }

        head = mergeSortByName(head, ascending);
        System.out.println("Inventory sorted by Name.");
    }

    // Merge Sort for sorting by Item Name
    private Item mergeSortByName(Item head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }

        Item mid = getMiddle(head);
        Item left = head;
        Item right = mid.next;
        mid.next = null;

        left = mergeSortByName(left, ascending);
        right = mergeSortByName(right, ascending);

        return mergeByName(left, right, ascending);
    }

    // Merge two sorted lists based on Item Name
    private Item mergeByName(Item left, Item right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        if (ascending) {
            if (left.itemName.compareToIgnoreCase(right.itemName) <= 0) {
                left.next = mergeByName(left.next, right, ascending);
                return left;
            } else {
                right.next = mergeByName(left, right.next, ascending);
                return right;
            }
        } else {
            if (left.itemName.compareToIgnoreCase(right.itemName) >= 0) {
                left.next = mergeByName(left.next, right, ascending);
                return left;
            } else {
                right.next = mergeByName(left, right.next, ascending);
                return right;
            }
        }
    }

    // Get the middle element of the list
    private Item getMiddle(Item head) {
        if (head == null) return null;

        Item slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display all items in the inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }

        Item temp = head;
        System.out.println("Inventory List:");
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

// Main class to test the Inventory Management System functionality
public class InventorySystemTest {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Add items to the inventory
        inventory.addItemAtBeginning("Apple", 101, 50, 0.99);
        inventory.addItemAtEnd("Banana", 102, 100, 0.59);
        inventory.addItemAtEnd("Orange", 103, 80, 1.29);
        inventory.addItemAtPosition(1, "Grapes", 104, 60, 2.49);

        // Display inventory
        inventory.displayInventory();

        // Search items by ID and Name
        inventory.searchItemById(102);
        inventory.searchItemByName("Orange");

        // Update quantity of an item
        inventory.updateItemQuantity(102, 150);

        // Remove item by ID
        inventory.removeItemById(103);

        // Display updated inventory
        inventory.displayInventory();

        // Calculate total inventory value
        inventory.calculateTotalInventoryValue();

        // Sort inventory by Item Name (ascending)
        inventory.sortInventoryByName(true);
        inventory.displayInventory();
    }
}
