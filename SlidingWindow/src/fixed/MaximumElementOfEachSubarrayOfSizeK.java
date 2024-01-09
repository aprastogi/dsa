package fixed;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumElementOfEachSubarrayOfSizeK {
    public static void main(String[] args) {
        int [] arr = {8,5,10,7,9,4,15,12,90,13};
        int k = 3;
        System.out.println(maximumElementOfEachSubarrayOfSizeK(arr, k));
    }

    private static List<Integer> maximumElementOfEachSubarrayOfSizeK(int[] arr, int k) {
        int i = 0, j = 0;
        int n = arr.length;
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        while(j < n){
            while(!deque.isEmpty() && deque.getLast() <= arr[j])
                deque.removeLast();
            deque.addLast(arr[j]);
            int currentWindow = j - i + 1;
            if(currentWindow < k){
                j++;
            }
            else if(currentWindow == k){
                // Calculate probable answer
                answer.add(deque.getFirst());
                // Remove the element from deque front if it matches with
                if(deque.getFirst().equals(arr[i])){
                    deque.removeFirst();
                }
                // Slide the window
                i++;
                j++;
            }
        }
        return answer;
    }
}
