public class CircularDoubleListFromBT {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	static void display(Node head) {
		Node tmp = head;

		do {
			System.out.println(tmp.data);
			tmp = tmp.right;
		} while (tmp != head);
	}

	static Node join(Node list1, Node list2) {

		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		Node leftLast = list1.left;
		Node rightLast = list2.left;

		leftLast.right = list2;
		list2.left = leftLast;

		list1.left = rightLast;
		rightLast.right = list1;

		return list1;
	}

	static Node bTreeToCList(Node head) {
		if (head == null)
			return null;

		Node left = bTreeToCList(head.left);
		Node right = bTreeToCList(head.right);

		head.left = head.right = head;

		return join(join(left, head), right);
	}

	static void printTree(Node root) {
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.println(root.data);
		printTree(root.right);
	}

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right.left = new Node(36);

		printTree(root);
		// head refers to the head of the Link List
		Node head = bTreeToCList(root);

		// Display the Circular LinkedList
		display(head);
	}
}