package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static int kthSmallestElement(int [] arr, int k){
        // Create a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int element : arr){
            pq.add(element);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.size() > 0 ? pq.peek() : -1;
    }

    public static void main(String[] args) {
        int [] arr = {3,7,1,9,2,10,32};
        int k = 3;
        System.out.println(k +"th Smallest element is : "+ kthSmallestElement(arr,k));
    }
}
