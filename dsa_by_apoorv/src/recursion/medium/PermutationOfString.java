package recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {

    public static void main(String[] args) {
        String str = "ABC";
        List<String> answer = new ArrayList<>();
        permutationOfString(str, "", answer);
        System.out.println(answer);
    }

    public static void permutationOfString(String input, String output, List<String> answer){
        if(input.isEmpty()){
            answer.add(output);
            return;
        }
        char ch = input.charAt(0);
        // run the loop to find out the answer possible for the current input and output
        for(int i = 0;i <= output.length(); i++){
            String f = output.substring(0, i);
            String s = output.substring(i);
            permutationOfString(input.substring(1), f + ch + s, answer);
        }
    }
}
