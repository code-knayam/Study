public class DeleteNode {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node deleteNodeByVal(int val, Node root) {
		Node temp = root;
		Node prev = null;

		if (temp.data == val) {
			return root.next;
		}

		while (temp != null && temp.data != val) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null) {
			return root;
		}

		prev.next = temp.next;
		return root;
	}

	public static void print(Node root) {
		Node start = root;

		while (start != null) {
			System.out.println(start.data);
			start = start.next;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);

		root.next = node2;
		node2.next = node3;
		node3.next = node4;

		root = deleteNodeByVal(3, root);
		print(root);
	}
}