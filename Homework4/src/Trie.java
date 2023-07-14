
import java.util.HashMap;

public class Trie {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("hello");
    }
    public static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean validWord;
        public TrieNode() {
            this.children = new HashMap<>();
            this.validWord = false;
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        insertHelper(word, root, 0);
    }

    public void insertHelper(String word, TrieNode n, int index) {
        if (index == word.length()) {
            n.validWord = true;
            return;
        }
        char c = word.charAt(index);
        if (!n.children.containsKey(c)) {
            n.children.put(c, new TrieNode());
        }
        insertHelper(word, n.children.get(c), index+1);
    }

    public boolean isValidWord(String word) {
        return isValidWordHelper(word, root, 0);
    }

    public boolean isValidWordHelper(String word, TrieNode n, int index) {
        if (index == word.length()) {
            return n.validWord;
        }
        char c = word.charAt(index);
        if (!n.children.containsKey(c)) {
            return false;
        }
        return isValidWordHelper(word, n.children.get(c), index+1);
    }

    public void remove(String word) {
        if (!isValidWord(word)) {
            return;
        }
        validRemoveHelper(word, root, 0);
    }

    public boolean validRemoveHelper(String word, TrieNode n, int index) {
        char c = word.charAt(index);
        if (index == word.length()) {
            return n.children.isEmpty();
        }

        if (validRemoveHelper(word, n.children.get(c), index + 1)) {
            n.children.remove(c);
            return n.children.isEmpty();
        } else {
            return false;
        }
    }
}