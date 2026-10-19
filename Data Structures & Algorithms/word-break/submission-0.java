class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) { 
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.letters[c - 'a'] == null) 
                curr.letters[c - 'a'] = new TrieNode();
            curr = curr.letters[c - 'a']; 
        }

        curr.end = true;
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

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        PrefixTree pt = new PrefixTree();
        for (String str : wordDict) {
            pt.insert(str);
        }

        Boolean[] memo = new Boolean[s.length() + 1];
        return dfs(0, pt.root, pt.root, s, memo);
    }

    private boolean dfs(int idx, TrieNode curr, TrieNode root, String s, Boolean[] dp) {
        if (curr == null) {
            return false;
        }

        if (idx == s.length()) {
            return curr.end;
        }

        if (curr.end) {
            if (dp[idx] == null) dp[idx] = dfs(idx, root, root, s, dp);
            if (dp[idx]) return true;
        }

        return dfs(idx + 1, curr.letters[s.charAt(idx) - 'a'], root, s, dp);
    }
}

// recursive solution

/*
1. recursively go through trie tree trying all combinations of word orders 
base cases
 a. current node not in the trie  
 b. idx is length of s return true if we are at the end of the word; 
recursive case
 a. if is icw reset trienode to root dfs(i+1, root, 0);
 b. and recurisive call to 

*/
