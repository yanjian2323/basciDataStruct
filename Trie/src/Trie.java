import java.util.TreeMap;

// 字典树(前缀树)的实现
public class Trie {
    private class Node {
        public boolean isWord;//是否是一个单词
        public TreeMap<Character, Node> next;

        public Node() {
            isWord = false;
            next = new TreeMap<>();
        }
    }

    private int size;//单词的数量
    private Node root;

    public Trie() {
        root = new Node();
        size = 0;
    }

    // 往字典树添加单词,迭代实现
    public void add(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    // 字典树中是否包含某个单词,迭代实现
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 字典树中是否包含给定的字符串前缀
    public boolean isPrefix(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    // 往字典树添加单词,递归实现
    public void insert(String word) {
        insert(word, 0, root);
    }

    private void insert(String word, int index, Node cur) {
        if (index == word.length()) {
            if (!cur.isWord) {
                cur.isWord = true;
                size++;
            }
            return;
        }
        char c = word.charAt(index);
        if (cur.next.get(c) == null) {
            cur.next.put(c, new Node());
        }
        insert(word, index + 1, cur.next.get(c));
    }

    // 字典树中是否包含某个单词,递归实现
    public boolean find(String word) {
        return find(word, 0, root);
    }

    public boolean find(String word, int index, Node cur) {
        if (index == word.length()) {
            return cur.isWord;
        }
        char c = word.charAt(index);
        if (cur.next.get(c) == null) {
            return false;
        } else {
            return find(word, index + 1, cur.next.get(c));
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}
