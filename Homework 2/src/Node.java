
public class Node {
    public int val;
    public Node next;
    public Node prev;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
        this.prev=null;
    }
    public Node(int data) {
        this.val = data;
        this.prev = null;
        this.next = null;
    }

    public Node() {
        this.val = Integer.parseInt(null);
        this.next = null;
        this.prev=null;
    }
}