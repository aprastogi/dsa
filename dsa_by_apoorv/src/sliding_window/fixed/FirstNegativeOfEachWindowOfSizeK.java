package sliding_window.fixed;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FirstNegativeOfEachWindowOfSizeK {
    public static void main(String[] args) {
        int [] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println(firstNegativeOfEachWindowOfSizeK(arr, k));
    }

    private static List<Integer> firstNegativeOfEachWindowOfSizeK(int[] arr, int k) {
        int i = 0 , j = 0;
        int n = arr.length;
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        while(j < n){
            // If current element is negative, add it to deque
            if(arr[j] < 0){
                deque.addLast(arr[j]);
            }
            int currentWindow = j - i + 1;
            // If we don't reach to window size increment jth pointer
            if(currentWindow < k){
                j++;
            }
            // If we hit the window size
            else if(currentWindow == k){
                if(deque.isEmpty()){
                    answer.add(0);
                }
                else{
                    answer.add(deque.getFirst());
                    // remove first element of deque if it is equal to the ith pointer's value
                    if(deque.getFirst().equals(arr[i]))
                        deque.removeFirst();
                }
                // slide the window
                i++;
                j++;
            }
        }
        return answer;
    }
}
