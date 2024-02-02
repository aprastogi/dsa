package tries;
public class ShortestUniquePrefix {

    private static final Node root = new Node();

    public static void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.map.containsKey(word.charAt(i))){
                node.map.put(word.charAt(i), new Node());
            }
            node = node.map.get(word.charAt(i));
            node.increasePrefixCount();
        }
        node.setEnd();
    }

    public static String shortestPrefix(String word){
        StringBuilder sb = new StringBuilder();
        Node node = root;
        for(int i=0;i<word.length();i++){
            node = node.map.get(word.charAt(i));
            sb.append(word.charAt(i));
            if(node.getPrefixCount() == 1){
                return sb.toString();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String [] input = {"zebra","dog","dull","dove"};
        for(String str: input){
            insert(str);
        }
        for(String str: input){
            System.out.println("Shortest prefix for " + str + " is : " + shortestPrefix(str));
        }
    }
}
