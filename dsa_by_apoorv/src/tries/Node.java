package tries;

public class Node {
    Node[] links = new Node[26];
    boolean flag = false;
    int wordCount = 0;
    int prefixCount = 0;

    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    Node get(char ch){
        return links[ch - 'a'];
    }

    void setEnd(){
        flag = true;
    }

    boolean getEnd(){
        return flag;
    }

    void increaseWordCount(){
        wordCount++;
    }

    void decreaseWordCount(){
        wordCount--;
    }

    void increasePrefixCount(){
        prefixCount++;
    }

    void decreasePrefixCount(){
        prefixCount--;
    }

    int getWordCount(){
        return wordCount;
    }

    int getPrefixCount(){
        return prefixCount;
    }
}
