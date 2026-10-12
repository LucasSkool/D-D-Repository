import java.util.ArrayList;

public class LinkedlistOps {

	public static void removeValue(ListNode node) {
		node.setValue(node.getNext().getValue());
		node.setNext(node.getNext().getNext());
	}

	public static void printListInReverse(ListNode head) {
		if (head == null) { return; }
		printListInReverse(head.getNext());
		System.out.println(head.getValue());
		head = head.getNext();
	}
}