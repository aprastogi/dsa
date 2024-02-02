package heap;

import java.util.*;

public class TopKFrequentNumbers {

    static class Pair{
        int frequency;
        int element;

        public Pair(int frequency, int element){
            this.frequency = frequency;
            this.element = element;
        }

        public int getFrequency(){
            return frequency;
        }

        public int getElement(){
            return element;
        }
    }

    public static List<Integer> topKFrequentNumbers(int [] arr, int k){
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getFrequency));
        Map<Integer,Integer> map = new HashMap<>();
        // Populate map with the frequency of each element in an array
        for(int element : arr){
            map.put(element, map.getOrDefault(element, 0 ) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getValue(), entry.getKey()));
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(pq.size() > 0){
            answer.add(pq.poll().getElement());
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,1,3,2,2,4};
        int k = 2;
        System.out.println("Top K frequent numbers are : " + topKFrequentNumbers(arr, k));
    }
}
