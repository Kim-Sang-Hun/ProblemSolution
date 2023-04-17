import java.util.HashMap;
class Solution {
    class Node {
        HashMap<Character, Node> child;
        boolean isTerminal;
        public Node() {
            this.child = new HashMap<>();
            this.isTerminal = false;
        }
    }
    class Trie {
        Node root;
        public Trie() {
            this.root = new Node();
        }
        public boolean insertAndFind(String num) {
            Node cur = this.root;

            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                
                cur.child.putIfAbsent(c, new Node());
                cur = cur.child.get(c);
                if (cur.isTerminal) {
                    return false;
                }
                if (i == num.length() - 1) {
                    cur.isTerminal = true;
                }
            }
            return true;
        }

        public boolean isPreFix(String num) {
            Node cur = this.root;

            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                cur = cur.child.get(c);
                if (cur.isTerminal && i != num.length() - 1) {
                    return false;
                }
            }
            return true;
        }
    }
    public boolean solution(String[] phone_book) {
        Trie trie = new Trie();
        for (int i = 0; i < phone_book.length; i++) {
            if (!trie.insertAndFind(phone_book[i])) {
                return false;
            }
        }
        for (int i = 0; i < phone_book.length; i++) {
            if (!trie.isPreFix(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}