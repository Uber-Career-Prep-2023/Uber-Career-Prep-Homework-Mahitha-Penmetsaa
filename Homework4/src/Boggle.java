import java.util.*;

public class Boggle {
    public static void main(String[] args) {



        String dictionary[] = {"Ace", "Ape", "Cape", "Clap", "Clay", "Gape", "Grape", "Lace",
                "Lap", "Lay", "Mace", "Map", "May", "Pace", "Pay", "Rap",
                "Ray", "Tap", "Tape", "Trace", "Trap", "Tray", "Yap"};

        Character[][] board = {{'A', 'D', 'E'},
                {'R', 'C', 'P'},
                {'L', 'A', 'Y'}};


        System.out.println(boggle(board, dictionary));

    }

    static class TrieNode{
        //make changes to the implementation of the TrieNode so that we can better write out the methods--> basically making it easier

        HashMap<Character, TrieNode> children;
        boolean validWord;
        TrieNode(){
            children = new HashMap<>();
            validWord = false;
        }
        public void insert(String word){
            TrieNode curr = this;
            for(int i = 0; i < word.length(); i++){
                if(!curr.children.containsKey(word.charAt(i))){
                    curr.children.put(word.charAt(i), new TrieNode());
                }
                curr = curr.children.get(word.charAt(i));
            }
            curr.validWord = true;
        }
    }

    static Character[][] board;
    static String[] dictionary;
    static Set<String> answer;
    static Set<String> visited;
    static int rows;
    static int cols;

    static TrieNode root;

    public static ArrayList<String> boggle(Character[][] b, String[] dict){
        board = b;
        dictionary = dict;
        rows = board.length;
        cols = board[0].length;

        root = new TrieNode();
        for(String word : dictionary){
            root.insert(word.toUpperCase());
        }

        answer = new HashSet<>();
        visited = new HashSet<>();
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                dfs(row, col, root, "");
            }
        }
        return new ArrayList<>(answer);
    }

  //dfs in any possible direction (including diagonals)
    public static void dfs(int row, int col, TrieNode node, String word){

        if ( row < 0 || col <0 || row >= rows || col >= cols) {
            return;
        }

        if (!node.children.containsKey(board[row][col]) || visited.contains(row + "," + col)){
            return;
        }


        TrieNode curr = node.children.get(board[row][col]);
        word += board[row][col];
        if(curr.validWord){ 
            answer.add(word);
        }
        visited.add(row + "," + col);
        dfs(row+1, col, curr, word);
        dfs(row-1, col, curr, word);
        dfs(row, col + 1, curr, word);
        dfs(row, col - 1, curr, word);
        //diagonals
        dfs(row+1, col+1, curr, word);
        dfs(row+1, col-1, curr, word);
        dfs(row-1, col+1, curr, word);
        dfs(row-1, col-1, curr, word);

        visited.remove(row + "," + col);
        if(curr.children.isEmpty()){
            node.children.remove(board[row][col]);
        }
    }



}