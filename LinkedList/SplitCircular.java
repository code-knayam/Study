public class SplitCircular {
	static Node head1, head2;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	static void splitList(Node head) {
		if (head == null)
			return;

		Node fast_ptr = head, slow_ptr = head;

		while (fast_ptr.next != head && fast_ptr.next.next != head) {
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		}

		if (fast_ptr.next != head) {
			fast_ptr = fast_ptr.next;
		}

		head2 = slow_ptr.next;
		head1 = fast_ptr.next;

		slow_ptr.next = head1;
		fast_ptr.next = head2;
	}

	static void printList(Node head) {
		Node temp = head;

		do {
			System.out.println(head.data);
			head = head.next;
		} while (temp != head);
	}

	public static void main(String[] args) {

		Node head = new Node(12);
		head.next = new Node(56);
		head.next.next = new Node(2);
		head.next.next.next = new Node(11);
		// head.next.next.next.next = new Node(15);
		head.next.next.next.next = head;

		System.out.println("Original Circular Linked list ");
		printList(head);

		// Split the list
		splitList(head);
		System.out.println("");
		System.out.println("First Circular List ");
		printList(head1);
		System.out.println("");
		System.out.println("Second Circular List ");
		printList(head2);
	}
}