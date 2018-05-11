public class Main {

    public static void main(String[] args) {
	    Trie trie = new Trie();
	    trie.add("cat");
	    trie.add("yanjian");
	    System.out.println(trie.getSize());
	    System.out.println(trie.contains("cat"));
	    System.out.println(trie.isPrefix("yn"));
//        trie.insert("cat");
//        trie.insert("yanjian");
//        System.out.println(trie.getSize());
//        System.out.println(trie.find("yanjian"));
    }
}
