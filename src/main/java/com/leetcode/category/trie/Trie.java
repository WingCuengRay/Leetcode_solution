package com.leetcode.category.trie;
 

class Trie {
    private TrieNode root;

    public class TrieNode {
        private char ch;
        private TrieNode[] childs;
        private boolean isWord;

        public TrieNode(char ch, boolean isWord) {
            this.ch = ch;
            this.childs = new TrieNode[26];
            this.isWord = isWord;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode('#', false);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode currNode = this.root;

        for(final char ch: word.toCharArray()) {
            if(currNode.childs[ch - 'a'] == null) {
                currNode.childs[ch - 'a'] = new TrieNode(ch, false);
            }

            currNode = currNode.childs[ch - 'a'];
        }
        currNode.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode currNode = this.root;

        for(final char ch : word.toCharArray()) {
            if(currNode.childs[ch - 'a'] == null) {
                return false;
            }
            currNode = currNode.childs[ch - 'a'];
        }

        return currNode.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode currNode = this.root;

        for(char ch: prefix.toCharArray()) {
            if(currNode.childs[ch - 'a'] == null) {
                return false;
            }

            currNode = currNode.childs[ch - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */