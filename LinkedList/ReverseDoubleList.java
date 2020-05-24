
public class ReverseDoubleList {
	static Node head;

	static class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
		}
	}

	static void push(int new_data) {
		/* allocate node */
		Node new_node = new Node(new_data);

		/*
		 * since we are adding at the beginning, prev is always NULL
		 */
		new_node.prev = null;

		/* link the old list off the new node */
		new_node.next = head;

		/* change prev of head node to new node */
		if (head != null) {
			head.prev = new_node;
		}

		/* move the head to point to the new node */
		head = new_node;
	}

	static void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	static void reverse() {
		Node curr = head;
		Node temp = null;
		while (curr != null) {
			temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;
			curr = curr.prev;
		}

		if (temp != null) {
			head = temp.prev;
		}
	}

	public static void main(String[] args) {
		push(2);
		push(4);
		push(8);
		push(10);

		System.out.println("Original linked list ");
		printList();

		reverse();
		System.out.println("");
		System.out.println("The reversed Linked List is ");
		printList();
	}
}