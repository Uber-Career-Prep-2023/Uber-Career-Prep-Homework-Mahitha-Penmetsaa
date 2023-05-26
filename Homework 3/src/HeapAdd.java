import java.util.ArrayList;
public class HeapAdd{


    private ArrayList<Integer> arr;
    private int size;

    public HeapAdd() {
        arr = new ArrayList<>();

        this.insert(Integer.MAX_VALUE);
        this.size = 0;
    }


    public int top()
    {

        try {
            return arr.get(1);
        } catch (Exception e) {
            System.out.println("There are no elements in the heap.");
            return -1;
        }

    }

    public void insert(int x)
    {
        size += 1;
        arr.add(x);

        int xIndex = arr.size() - 1;

        int parentIndex = xIndex / 2;
        int parent = arr.get(parentIndex);


        while (parent > x && parent != Integer.MAX_VALUE) {
            arr.set(parentIndex, x);
            arr.set(xIndex, parent);
            xIndex = parentIndex;
            parentIndex = xIndex / 2;
            parent = arr.get(parentIndex);
        }
    }

    public void remove() {
        size -= 1;
        int temp = arr.get(arr.size() - 1);
        arr.set(arr.size() - 1, arr.get(1));
        arr.set(1, temp);


        arr.remove(arr.size() - 1);

        // heapify
        int leftIndex = 2;
        int rightIndex = 3;
        int left = 0;
        int right = 0;

        if (arr.size() > 2) {
            left = arr.get(leftIndex);
        } else {
            left = Integer.MAX_VALUE;
        }

        if (arr.size() > 3) {
            right = arr.get(rightIndex);
        } else {
            right = Integer.MAX_VALUE;
        }
        int xIndex = 1;
        int x = 0;

        if (arr.size() > 1) {
            x = arr.get(xIndex);
        }
        int chosenIndex = 0;
        int chosen = 0;

        while (chosen < x && chosenIndex < arr.size() - 1 && (left != Integer.MAX_VALUE || right != Integer.MAX_VALUE)) {

            if (left > x && right > x) {
                break;
            }

            if (left < right) {
                chosenIndex = leftIndex;
                chosen = left;
            } else {
                chosenIndex = rightIndex;
                chosen = right;
            }
            arr.set(chosenIndex, x);
            arr.set(xIndex, chosen);
            xIndex = chosenIndex;
            leftIndex = xIndex * 2;
            rightIndex = (xIndex * 2) + 1;

            if (leftIndex < arr.size()) {
                left = arr.get(leftIndex);
            } else {
                left = Integer.MAX_VALUE;
            }

            if (rightIndex < arr.size()) {
                right = arr.get(rightIndex);
            } else {
                right = Integer.MAX_VALUE;
            }
        }
    }


    public int getSize(){
        return size;
    }


}
