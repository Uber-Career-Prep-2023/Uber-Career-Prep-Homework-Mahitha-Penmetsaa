import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args){
        RunningMedian med = new RunningMedian();

        med.insert(100);
        System.out.println(med.runningMedian());
        med.insert(200);
        med.insert(150);
        System.out.println(med.runningMedian());
        med.insert(200);
        System.out.println(med.runningMedian());

    }
    PriorityQueue<Integer> small = null;
    PriorityQueue<Integer> large = null;

    public RunningMedian() {
        small = new PriorityQueue<>((x, y) -> (y
                - x));
        large = new PriorityQueue<>();
    }

    public void insert(int i) {
        if (small.size() == 0
                || small.peek() >= i) {
            small.offer(i);
        } else {
            large.offer(i);
        }
        balance();

    }

    public double runningMedian() {
        if (small.peek() == null && large.peek() == null) {
            return 0;
        } else if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }

    }

    public void balance() {
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        } else if (large.size() > small.size() + 1) {
            small.offer(large.poll());
        }

    }
}