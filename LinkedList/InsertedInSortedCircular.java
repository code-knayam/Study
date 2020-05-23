public class InsertedInSortedCircular {
	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	static void printList() {
		Node current = head;
		do {
			System.out.println(current.data);
			current = current.next;
		} while (current != head);
	}

	static void sortedInsert(Node newNode) {

		Node current = head;

		if (head == null) {
			newNode.next = newNode;
			head = newNode;
		} else if (head.data > newNode.data) {
			while (current.next != head) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;
			head = newNode;
		} else {
			while (current.next != head && current.next.data < newNode.data) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}

	}

	public static void main(String[] args) {
		int arr[] = new int[] { 12, 56, 2, 11, 1, 90 };

		/* start with empty linked list */
		Node temp = null;

		/*
		 * Create linked list from the array arr[]. Created linked list will be
		 * 1->2->11->12->56->90
		 */
		for (int i = 0; i < 6; i++) {
			temp = new Node(arr[i]);
			sortedInsert(temp);
		}

		printList();
	}
}
