public class InsertNode {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void print(Node root) {
		Node start = root;

		while (start != null) {
			System.out.println(start.data);
			start = start.next;
		}
	}

	public static Node insertNewNodeStart(Node root, int data) {
		Node newNode = new Node(data);

		newNode.next = root;
		root = newNode;

		return root;
	}

	public static Node insertNewNodeEnd(Node root, int data) {
		Node newNode = new Node(data);

		Node tmp = root;

		while (tmp.next != null) {
			tmp = tmp.next;
		}

		tmp.next = newNode;
		return root;
	}

	public static void main(String[] args) {

		Node root = new Node(4);
		Node node2 = new Node(5);
		Node node3 = new Node(6);

		root.next = node2;
		node2.next = node3;

		root = insertNewNodeStart(root, 2);
		print(root);

		System.out.println();

		root = insertNewNodeEnd(root, 10);
		print(root);

	}
}