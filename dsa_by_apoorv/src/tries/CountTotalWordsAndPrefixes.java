package tries;

public class CountTotalWordsAndPrefixes {

    private final Node root;

    CountTotalWordsAndPrefixes(){
        root = new Node();
    }

    void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.map.containsKey(word.charAt(i))){
                node.map.put(word.charAt(i), new Node());
            }
            node = node.map.get(word.charAt(i));
            node.increasePrefixCount();
        }
        node.increaseWordCount();
    }

    int countWord(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.map.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.map.get(word.charAt(i));
        }
        return node.getWordCount();
    }

    private int countPrefix(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.map.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.map.get(word.charAt(i));
        }
        return node.getPrefixCount();
    }

    private void erase(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.map.containsKey(word.charAt(i))){
                return;
            }
            node = node.map.get(word.charAt(i));
            node.decreasePrefixCount();
        }
        node.decreaseWordCount();
    }

    public static void main(String[] args) {
        CountTotalWordsAndPrefixes trie = new CountTotalWordsAndPrefixes();
        trie.insert("apoorv");
        trie.insert("apoorv");
        trie.insert("ishan");
        trie.insert("app");
        System.out.println(trie.countWord("apoorv"));
        System.out.println(trie.countWord("ishan"));
        System.out.println(trie.countPrefix("ap"));
        trie.erase("apoorv");
        System.out.println(trie.countWord("apoorv"));
    }
}
