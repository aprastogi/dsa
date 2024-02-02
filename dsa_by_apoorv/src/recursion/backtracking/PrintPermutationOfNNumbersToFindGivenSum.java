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

    public static void main(String[] args) {
        int n = 2;
        int sum = 4;
        List<List<Integer>> answer =  permutationOfNumbers(n, sum);
        answer.forEach(System.out::println);
    }
}
