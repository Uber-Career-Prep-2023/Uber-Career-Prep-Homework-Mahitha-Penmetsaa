

public class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public class TrieNode {
        public TrieNode[] children;
        public boolean validWord;
        public TrieNode(){
            this.children = new TrieNode[26];
            this.validWord = false;
        }
    }

    public void insert(String word) {
        word = word.toLowerCase();
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            int index = letter - 'a';

            if(curr.children[index] == null){
                TrieNode node = new TrieNode();
                curr.children[index] = node;
                curr = node;
            } else {
                curr = curr.children[index];
            }
        }
        curr.validWord = true;
    }

    public boolean isValidWord(String word) {
        TrieNode curr = root;
        for (int i =0; i < word.length(); i++){
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
    public TrieNode removeHelper(TrieNode curr, String word, int depth){
        if (curr == null) {
            return null;
        }
        if(depth == word.length()){
            if (curr.validWord){
                curr.validWord = false; //it
            }
            for(int i=0; i < curr.children.length; i++){
                curr.children[i] = null;
            }
            return curr;
        }

        int index = word.charAt(depth)-'a';
        curr.children[index] = removeHelper(curr.children[index], word, depth+1);

        return curr;
    }
    public void remove(String word) {
        removeHelper(root, word, 0);
    }


}