/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package github;

/**
 *
 * @author ashin
 */
public class linkedlist {

    /**
     * @param args the command line arguments
     */
    

    Node head; // head of the list

    // Node class
    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node at the end
    public void append(int newData) {
        Node newNode = new Node(newData);

        // If the LinkedList is empty, then make the new node as head
        if (head == null) {
            head = newNode;
            return;
        }

        // Else traverse till the last node and insert the newNode there
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    // Method to insert a new node at the beginning
    public void prepend(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    // Method to delete a node by key
    public void delete(int key) {
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in the list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    // Method to print the LinkedList
    public void printList() {
        Node currNode = head;

        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    // Main method to test the above functions
    public static void main(String[] args) {
        linkedlist list = new linkedlist();

        // Insert elements
        list.append(1);
        list.append(2);
        list.append(3);
        list.prepend(0);
        list.printList();  // Output: LinkedList: 0 1 2 3 

        // Delete element
        list.delete(2);
        list.printList();  // Output: LinkedList: 0 1 3
    }
}
