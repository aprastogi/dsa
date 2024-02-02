package heap;

import java.util.*;

public class KClosetNumbers {

    static class Pair{
        int first, second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        public int getFirst(){
            return first;
        }
    }

    public static List<Integer> kClosetNumbers(int [] arr, int x, int k){
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getFirst).reversed());
        for(int element : arr){
            pq.add(new Pair(Math.abs(element - x), element));
            if(pq.size() > k)
                pq.poll();
        }
        while(pq.size() > 0){
            answer.add(pq.poll().second);
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] arr = {5,6,7,8,9};
        int x = 7;
        int k = 3;
        System.out.println("K Closet numbers : " +kClosetNumbers(arr, x, k));
    }
}
