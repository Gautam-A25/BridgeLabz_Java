package linkedlist;

/*
4. Singly Linked List: Inventory Management System
Problem Statement: Design an inventory management system using a singly linked list where each node stores
information about an item such as Item Name, Item ID, Quantity, and Price. Implement the following functionalities:

- Add an item at the beginning, end, or at a specific position.
- Remove an item based on Item ID.
- Update the quantity of an item by Item ID.
- Search for an item based on Item ID or Item Name.
- Calculate and display the total value of inventory (Sum of Price * Quantity for each item).
- Sort the inventory based on Item Name or Price in ascending or descending order.

Hint:
- Use a singly linked list where each node represents an item in the inventory.
- Implement sorting using an appropriate algorithm (e.g., merge sort) on the linked list.
- For total value calculation, traverse through the list and sum up Quantity * Price for each item.
*/

// Node class (each node is an Item)
class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Singly Linked List Inventory Class
class InventorySLL {
    private Item head;

    // Add at beginning (O(1))
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newNode = new Item(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add at end (O(n))
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newNode = new Item(itemName, itemId, quantity, price);

        if (head == null) {
            head = newNode;
            return;
        }

        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    // Add at position (1-based index)
    public void addAtPosition(int pos, String itemName, int itemId, int quantity, double price) {
        if (pos <= 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        Item newNode = new Item(itemName, itemId, quantity, price);
        Item temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range. Adding at end.");
            addAtEnd(itemName, itemId, quantity, price);
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove item by ID
    public void removeById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed: " + itemId);
            return;
        }

        Item prev = head;
        Item curr = head.next;

        while (curr != null) {
            if (curr.itemId == itemId) {
                prev.next = curr.next;
                curr.next = null; // cleanup
                System.out.println("Item removed: " + itemId);
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Item not found.");
    }

    // Update quantity by ID
    public void updateQuantity(int itemId, int newQty) {
        if (newQty < 0) {
            System.out.println("Invalid quantity. Quantity cannot be negative.");
            return;
        }

        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQty;
                System.out.println("Quantity updated for Item ID: " + itemId);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found.");
    }

    // Search by ID
    public void searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Found: " + temp.itemName +
                        " | ID=" + temp.itemId +
                        " | Qty=" + temp.quantity +
                        " | Price=" + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by Name
    public void searchByName(String itemName) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Found: " + temp.itemName +
                        " | ID=" + temp.itemId +
                        " | Qty=" + temp.quantity +
                        " | Price=" + temp.price);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No item found with name: " + itemName);
    }

    // Total inventory value
    public double totalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += (temp.quantity * temp.price);
            temp = temp.next;
        }
        return total;
    }

    // ---------- Sorting using Merge Sort ----------
    public void sortByName(boolean ascending) {
        head = mergeSort(head, true, ascending);
        System.out.println("Sorted by Item Name (" + (ascending ? "ASC" : "DESC") + ")");
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, false, ascending);
        System.out.println("Sorted by Price (" + (ascending ? "ASC" : "DESC") + ")");
    }

    private Item mergeSort(Item node, boolean byName, boolean ascending) {
        if (node == null || node.next == null) return node;

        Item mid = getMiddle(node);
        Item rightHead = mid.next;
        mid.next = null;

        Item left = mergeSort(node, byName, ascending);
        Item right = mergeSort(rightHead, byName, ascending);

        return merge(left, right, byName, ascending);
    }

    private Item getMiddle(Item node) {
        Item slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Item merge(Item a, Item b, boolean byName, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean chooseA;

        if (byName) {
            int cmp = a.itemName.compareToIgnoreCase(b.itemName);
            chooseA = ascending ? (cmp <= 0) : (cmp > 0);
        } else {
            chooseA = ascending ? (a.price <= b.price) : (a.price > b.price);
        }

        if (chooseA) {
            a.next = merge(a.next, b, byName, ascending);
            return a;
        } else {
            b.next = merge(a, b.next, byName, ascending);
            return b;
        }
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No inventory items.");
            return;
        }

        System.out.println("\n---- Inventory Items ----");
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.itemName +
                    " | ID=" + temp.itemId +
                    " | Qty=" + temp.quantity +
                    " | Price=" + temp.price);
            temp = temp.next;
        }
    }
}

public class ItemNode {
    public static void main(String[] args) {

        InventorySLL inv = new InventorySLL();

        inv.addAtEnd("Mouse", 201, 5, 499.0);
        inv.addAtEnd("Keyboard", 202, 2, 999.0);
        inv.addAtBeginning("Laptop", 200, 1, 65000.0);
        inv.addAtPosition(2, "Headphones", 203, 3, 1499.0);

        inv.displayAll();
        System.out.println("\nTotal Inventory Value = " + inv.totalInventoryValue());

        inv.searchById(202);
        inv.updateQuantity(201, 10);

        inv.sortByName(true);
        inv.displayAll();

        inv.sortByPrice(false);
        inv.displayAll();

        inv.removeById(203);
        inv.displayAll();
    }
}