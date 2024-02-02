package heap;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static int minCostToConnectRopes(int [] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int minCost = 0;
        for(int rope : arr){
            pq.add(rope);
        }
        while(pq.size() >= 2){
            int rope1 = pq.poll();
            int rope2 = pq.poll();
            minCost += rope1 + rope2;
            pq.add(rope1 + rope2);
        }
        return minCost;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        System.out.println("Min Cost to connect ropes is : " + minCostToConnectRopes(arr));
    }
}
