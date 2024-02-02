package tries;

import java.util.HashMap;
import java.util.Map;

public class Node {
    Map<Character,Node> map = new HashMap<>();
    boolean flag = false;
    int wordCount = 0;
    int prefixCount = 0;

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
