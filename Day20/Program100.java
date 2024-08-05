// https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list
import java.io.*;
import java.util.*;

class LinkedList {
    Node head; 
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    void segregateEvenOdd()
    {
        Node end = head;
        Node prev = null;
        Node curr = head;

        //  Get pointer to last Node 
        while (end.next != null)
            end = end.next;

        Node new_end = end;
        // get all odd elements at start to the end
        while (curr.data % 2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }
        //when even start
        if (curr.data % 2 == 0) {
            head = curr;
            while (curr != end) {
                if (curr.data % 2 == 0) { //if even skip it
                    prev = curr;//taking refernce of previous nodes
                    curr = curr.next;
                }
                else {
                    prev.next = curr.next;//remove the link
                    curr.next = null;
                    //if odd push it to the end of new_end
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        }

        else
            prev = curr;

        if (new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }

    void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        LinkedList llist = new LinkedList();
        llist.push(11);
        llist.push(10);
        llist.push(8);
        llist.push(6);
        llist.push(4);
        llist.push(2);
        llist.push(0);
        System.out.println("Original Linked List");
        llist.printList();

        llist.segregateEvenOdd();

        System.out.println("Modified Linked List");
        llist.printList();
    }
} /* This code is contributed by Rajat Mishra */