package recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetOfString {
    public static void main(String[] args) {
        String str = "ABC";
        System.out.println(allSubsetOfString(str, ""));
    }

    public static List<String> allSubsetOfString(String input, String output){
        List<String> answer =  new ArrayList<>();
        if(input.isEmpty()){
            answer.add(output);
            return answer;
        }
        char ch = input.charAt(0);
        List<String> left = allSubsetOfString(input.substring(1), output + ch);
        List<String> right = allSubsetOfString(input.substring(1), output);
        left.addAll(right);
        return left;
    }
}
