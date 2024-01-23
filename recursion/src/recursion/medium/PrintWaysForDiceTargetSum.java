package recursion.medium;

/*
https://www.geeksforgeeks.org/count-ways-to-obtain-given-sum-by-repeated-throws-of-a-dice/
*/

import java.util.ArrayList;
import java.util.List;

public class PrintWaysForDiceTargetSum {

    public static void main(String[] args) {
        int target = 4;
        List<String> answer = new ArrayList<>();
        printWaysForDiceTargetSum(target, "", answer);
        System.out.println(answer);
    }

    public static void printWaysForDiceTargetSum(int target, String output, List<String> answer){
        if(target == 0){
            answer.add(output);
            return;
        }

        // Run a loop for a dice throw and also ensure i should not be more than target
        for(int i=1; i<=6 && i<=target ;i++){
            printWaysForDiceTargetSum(target - i, output + i, answer);
        }
    }
}
