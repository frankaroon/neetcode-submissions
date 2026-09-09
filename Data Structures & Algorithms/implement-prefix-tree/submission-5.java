class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) { 
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.letters[c - 'a'] == null) {
                curr.letters[c - 'a'] = new TrieNode();
            }
            curr = curr.letters[c - 'a']; 
        }

        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.letters[c - 'a'] == null) 
                return false;
            curr = curr.letters[c - 'a']; 
        }

        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.letters[c - 'a'] == null) 
                return false;
            curr = curr.letters[c - 'a']; 
        }

        return true;
    }
}

class TrieNode {
    boolean end;
    TrieNode[] letters;

    public TrieNode() {
        this.end = false;
        this.letters = new TrieNode[26];
    }
}
