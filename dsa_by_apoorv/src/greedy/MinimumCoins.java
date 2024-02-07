package greedy;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/
 */
public class MinimumCoins {

    public static List<Integer> minCoins(int [] coins, int n){
        List<Integer> answer = new ArrayList<>();
        int ndx = coins.length - 1;
        while(n > 0){
            // while the current denomination of coin is lesser than the target value, use this denomination
            while(coins[ndx] <= n){
                answer.add(coins[ndx]);
                n -= coins[ndx];
            }
            // try with the lesser denomination of coin
            ndx--;
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] coins = {1,2,4,10,20,50,100,500};
        int n = 93;
        System.out.println("Minimum coins needed is : " + minCoins(coins, n));
    }
}
