// https://www.geeksforgeeks.org/linked-list-in-zig-zag-fashion/
class Program98 {

	/* Link list Node */
	static class Node {
		int data;
		Node next;
	}
	static Node head = null;
	static int temp = 0;

	static void zigZagList(Node head)
	{
		boolean flag = true;
		Node current = head;
		while (current != null && current.next != null) {
			if (flag == true) 
			{
				//first one will be small
				if (current.data > current.next.data) {
					temp = current.data;
					current.data = current.next.data;
					current.next.data = temp;
				}
			}
			else 
			{
				//second should be greater
				if (current.data < current.next.data) {
					temp = current.data;
					current.data = current.next.data;
					current.next.data = temp;
				}
			}

			current = current.next;

			flag = !(flag);
		}
	}
	static void push(int new_data)
	{
		Node new_Node = new Node();

		new_Node.data = new_data;
		new_Node.next = (head);
		(head) = new_Node;
	}

	static void printList(Node Node)
	{
		while (Node != null) {
			System.out.print(Node.data + "->");
			Node = Node.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args)
	{
		/* Start with the empty list */
		// Node head = null;

		// create a list 4 -> 3 -> 7 -> 8 -> 6 -> 2 -> 1
		// answer should be -> 3 7 4 8 2 6 1
		push(1);
		push(2);
		push(6);
		push(8);
		push(7);
		push(3);
		push(4);

		System.out.println("Given linked list ");
		printList(head);

		zigZagList(head);

		System.out.println("Zig Zag Linked list ");
		printList(head);
	}
}

// This code is contributed by
// Prerna Saini.
