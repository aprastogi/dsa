package greedy;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/fractional-knapsack-problem/
 */
public class FractionalKnapsack {

    static class Pair{
        int weight, value;
        public Pair(int weight, int value){
            this.weight = weight;
            this.value = value;
        }

        public int getWeight(){
            return weight;
        }

        public int getValue(){
            return value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }

    public static int maxProfit(int [] weight, int [] value, int W){
        int profit = 0;
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<weight.length;i++){
            list.add(new Pair(weight[i], value[i]));
        }
        // sort the list as per the per weight value
        list.sort((p1, p2) -> {
            double r1 = (double) p1.getValue() / (double) p1.getWeight();
            double r2 = (double) p2.getValue() / (double) p2.getWeight();
            return Double.compare(r2, r1);
        });
        for(Pair pair : list){
            int currWeight = pair.getWeight();
            int currValue = pair.getValue();
            // if current weight is lesser than the total weight take the profit of that weight
            if(W >= currWeight){
                profit+= currValue;
                W -= currWeight;
            } else{
                // take the profit using fractional weight
                profit += (currValue / currWeight) * W;
                break;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int [] value = {60,100,120};
        int [] weight = {10,20,30};
        int W = 50;
        System.out.println("Maximum profit is : " + maxProfit(weight, value, W));
    }
}
