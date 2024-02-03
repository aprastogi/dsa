package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintPermutationOfNNumbersToFindGivenSum {

    public static List<List<Integer>> permutationOfNumbers(int n, int sum){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        permutationOfNumbersUtil(n, sum, current, result);
        return result;
    }

    public static void permutationOfNumbersUtil(int n, int target, List<Integer> current, List<List<Integer>> result){
        if(n == 0 && target == 0){
            // found one possible solution
            result.add(current);
            return;
        }
        for(int i=1;i<=target;i++){
            // try to add current number to the result
            current.add(i);
            permutationOfNumbersUtil(n-1, target - i, new ArrayList<>(current), result);
            // backtrack
            current.remove(current.size() - 1);
        }
    }

    // Solved without backtracking
    public static void permutationOfNumbers2(int n, int sum, String output, List<String> result){
        if(n == 0 && sum == 0){
            // found one solution
            result.add(output);
        }
        if(n == 0 || sum == 0){
            return;
        }
        for(int i=1;i<=sum;i++){
            permutationOfNumbers2(n-1, sum - i, output + i, result);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int sum = 4;
        List<List<Integer>> answer =  permutationOfNumbers(n, sum);
        answer.forEach(System.out::println);
        List<String> result = new ArrayList<>();
        permutationOfNumbers2(n, sum, "", result);
        System.out.println(result);
    }
}
