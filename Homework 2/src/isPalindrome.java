public class isPalindrome {
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node start = head;
        Node end = head;

        while (end.next != null) {
            end = end.next;
        }

        while (start != end && end.next != start) {
            if (start.val != end.val) {
                return false;
            }
            start = start.next;
            end = end.prev;
        }

        return true;
    }

}
