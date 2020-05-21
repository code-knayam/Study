public class SingleListTraversal {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	static void printList(Node head) {
		Node n = head;

		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		head.next = second; // Link first node with the second node
		second.next = third; // Link first node with the second node

		printList(head);
	}
}