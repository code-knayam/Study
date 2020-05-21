public class CyclicDetection {

	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void push(int new_data) {
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	public static void detectLoop() {
		Node slow = head, fast = head;

		while (fast != null && slow != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("True");
				return;
			}
		}
		System.out.println("False");
	}

	public static void main(String[] args) {
		push(20);
		push(4);
		push(15);
		push(10);

		head.next.next.next.next = head;

		detectLoop();
	}
}