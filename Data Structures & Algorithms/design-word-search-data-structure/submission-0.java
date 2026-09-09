class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = (c == '.') ? 26 : c - 'a';
            if (curr.letters[index] == null) {
                curr.letters[index] = new TrieNode();
            }
            curr = curr.letters[index];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        return hasWord(root, word, 0);
    }

    private boolean hasWord(TrieNode root, String word, int index) {
        if (index >= word.length()) return root.eow;
        
        if (word.charAt(index) == '.') {
            // go through all the children and place them on the stack
            for (int i = 0; i < 26; i++) {
                if (root.letters[i] != null && hasWord(root.letters[i], word, index + 1))
                    return true; 
            }
            return false;
        } else {
            // just place the next letter on the stack
            if (root.letters[word.charAt(index) - 'a'] == null) return false;
            return hasWord(root.letters[word.charAt(index) - 'a'], word, index + 1);
        }
    }
}

class TrieNode {
    boolean eow;
    TrieNode[] letters;

    public TrieNode() {
        this.eow = false;
        this.letters = new TrieNode[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */