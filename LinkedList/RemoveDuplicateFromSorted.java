public class RemoveDuplicateFromSorted {
	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	static void removeDuplicates() {
		Node temp = head;

		if (temp == null || temp.next == null) {
			return;
		}

		while (temp != null) {
			// if (temp.next.data == temp.data) {
			// temp.next = temp.next.next;
			// } else {
			// temp = temp.next;
			// }

			Node curr = temp;

			while (temp != null && temp.data == curr.data)
				temp = temp.next;

			curr.next = temp;
			curr = curr.next;
		}

	}

	static void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public static void main(String[] args) {

		push(20);
		push(13);
		push(13);
		push(11);
		push(11);
		push(11);

		System.out.println("List before removal of duplicates");
		printList();

		removeDuplicates();

		System.out.println("List after removal of elements");
		printList();
	}
}