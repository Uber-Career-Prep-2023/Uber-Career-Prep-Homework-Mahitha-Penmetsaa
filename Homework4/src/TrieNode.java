public class TrieNode {

    public TrieNode[] children;
    public boolean validWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.validWord = false;
    }
}