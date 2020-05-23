import java.util.HashSet;

public class RemoveDuplicateUnsorted {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	static void removeDuplicate(Node head) {
		Node temp = head, prev = null;

		HashSet<Integer> vals = new HashSet<>();

		while (temp != null) {
			if (vals.contains(temp.data)) {
				prev.next = temp.next;
			} else {
				vals.add(temp.data);
				prev = temp;
			}
			temp = temp.next;
		}

	}

	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Node start = new Node(10);
		start.next = new Node(12);
		start.next.next = new Node(11);
		start.next.next.next = new Node(11);
		start.next.next.next.next = new Node(12);
		start.next.next.next.next.next = new Node(11);
		start.next.next.next.next.next.next = new Node(10);

		System.out.println("Linked list before removing duplicates :");
		printList(start);

		removeDuplicate(start);

		System.out.println("\nLinked list after removing duplicates :");
		printList(start);
	}
}
