package medium.implemenetTrie;

import util.TrieNode;

public class Trie {
    TrieNode node;

    public Trie() {
        this.node = new TrieNode();
    }

    public void insert(String word) {
        TrieNode head = node;

        for (char c : word.toCharArray()) {
            if (!head.children.containsKey(c)) {
                head.children.put(c, new TrieNode());
            }

            head = head.children.get(c);
        }

        head.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode head = node;

        for (char c : word.toCharArray()) {
            if (!head.children.containsKey(c)) {
                return false;
            }

            head = head.children.get(c);
        }

        return head.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode head = node;

        for (char c : prefix.toCharArray()) {
            if (!head.children.containsKey(c)) {
                return false;
            }

            head = head.children.get(c);
        }

        return true;
    }
}