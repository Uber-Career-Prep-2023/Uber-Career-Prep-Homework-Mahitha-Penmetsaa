import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Pair> arr;
    public PriorityQueue() {
        arr = new ArrayList<>();
        // filler for first element of backing array
        this.insert("start", Integer.MAX_VALUE);
    }

    public int top() {
        return arr.get(1).getValue();
    }
    public void insert(String x, int weight) {
        arr.add(new Pair(x, weight));

        int xIndex = arr.size() - 1;

        int parentIndex = xIndex / 2;
        Pair parent = arr.get(parentIndex);

        while (parent.getValue() > weight && parent.getValue() != Integer.MAX_VALUE) {
            arr.set(parentIndex, new Pair(x, weight));
            arr.set(xIndex, parent);
            xIndex = parentIndex;
            parentIndex = xIndex / 2;
            parent = arr.get(parentIndex);
        }
    }

    public void remove() {
        Pair temp = arr.get(arr.size() - 1);
        arr.set(arr.size() - 1, arr.get(1));
        arr.set(1, temp);

        arr.remove(arr.size() - 1);

        // heapify
        int leftIndex = 2;
        Pair left = arr.get(leftIndex);
        int rightIndex = 3;
        Pair right = arr.get(rightIndex);
        int xIndex = 1;
        Pair x = arr.get(xIndex);
        int chosenIndex = 0;
        Pair chosen = new Pair("temp", Integer.MIN_VALUE);

        while (chosen.getValue() < x.getValue() && chosenIndex < arr.size() - 1) {
            if (left.getValue() < right.getValue()) {
                chosenIndex = leftIndex;
                chosen = left;
            } else {
                chosenIndex = rightIndex;
                chosen = right;
            }
            arr.set(chosenIndex, x);
            arr.set(xIndex, chosen);
            if (chosen == left) {
                xIndex = leftIndex;
            } else {
                xIndex = rightIndex;
            }
            leftIndex = xIndex * 2;
            rightIndex = (xIndex * 2) + 1;

            if (leftIndex < arr.size()) {
                left = arr.get(leftIndex);
            } else {
                left = new Pair("temp", Integer.MAX_VALUE);
            }

            if (rightIndex < arr.size()) {
                right = arr.get(rightIndex);
            } else {
                right = new Pair("temp", Integer.MAX_VALUE);
            }
        }
    }

    public static class Pair {
        private final String key;
        private final int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }
}
