public class MoveNthLasttoFront {
    public static Node moveElement(Node head, int k){
        Node iterate = new Node();
        Node lower, higher = iterate;
        lower = head;
        higher = head;

        for (int i = 0; i < k; i++) {
            higher=higher.next;
        }
        if (higher==null) return head;

        if (higher.next!=null){
            higher = higher.next;
            lower = lower.next;
        }
        Node first = new Node();
        first = lower.next;
        first.next = head;
        lower.next=lower.next.next;

        return first;

    }
}
