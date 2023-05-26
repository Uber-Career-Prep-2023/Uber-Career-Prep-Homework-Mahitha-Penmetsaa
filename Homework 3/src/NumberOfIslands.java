public class NumberOfIslands {

   private int[][] arr;
  private boolean[][] visited;
  private int count;
 private boolean found;

    public static void main(String[] args) {
        int[][] arr1 = {{1,0,1,1,1}, {1,1,0,1,1}, {0,1,0,0,0}, {0,0,0,1,0}, {0,0,0,0,0}};
        NumberOfIslands n1 = new NumberOfIslands(arr1);
        System.out.println(n1.numIslands());
    }

    public NumberOfIslands(int arr[][]) {
        this.arr = arr;
        this.visited = new boolean[arr.length][arr[0].length];
        this.count = 0;
        this.found = false;
    }
    public int numIslands() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (!visited[i][j]) {
                    look(i, j);
                    if (found) {
                        count += 1;
                        found = false;
                    }
                }
            }
        }
        return count;
    }
    public void look(int row, int column) {

        if (arr[row][column] == 1 && !visited[row][column]) {
            visited[row][column] = true;

            if (row - 1 >= 0) {
                look(row - 1 , column);
            }

            if (row + 1 < arr.length) {
                look(row + 1, column);
            }


            if (column - 1 >= 0) {
                look(row, column - 1);
            }


            if (column + 1 < arr[0].length) {
                look(row, column + 1);
            }

            found = true;
        }
    }




}
