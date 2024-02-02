package tries;

public class Trie {

    private final Node root;

    Trie(){
        root = new Node();
    }

    void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.map.containsKey(word.charAt(i))){
                node.map.put(word.charAt(i), new Node());
            }
            node = node.map.get(word.charAt(i));
        }
        node.setEnd();
    }

    boolean search(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.map.containsKey(word.charAt(i))){
                return false;
            }
            node = node.map.get(word.charAt(i));
        }
        return node.getEnd();
    }

    boolean searchWithPrefix(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.map.containsKey(word.charAt(i))){
                return false;
            }
            node = node.map.get(word.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apoorv");
        trie.insert("ishan");
        trie.insert("apple");
        System.out.println(trie.search("apoorv"));
        System.out.println(trie.search("banana"));
        System.out.println(trie.search("ishan"));
        System.out.println(trie.searchWithPrefix("app"));
        System.out.println(trie.searchWithPrefix("apps"));
    }
}
