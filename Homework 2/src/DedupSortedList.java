public class DedupSortedList {
    public static Node dedup(Node head) {
        Node node = head; // Iterates over node
        while (node != null && node.next != null) {
            if (node.val != node.next.val) {
                node = node.next;
            } else {// Skips next node
                node.next = node.next.next;
            }
        }
        return head;
    }
}
