package heap;

import java.util.*;

public class FrequencySort {

    public static List<Integer> sortArray(int [] arr){
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<TopKFrequentNumbers.Pair> pq = new PriorityQueue<>(Comparator.comparingInt(TopKFrequentNumbers.Pair::getFrequency).reversed());
        Map<Integer,Integer> map = new HashMap<>();
        // Populate map with the frequency of each element in an array
        for(int element : arr){
            map.put(element, map.getOrDefault(element, 0 ) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new TopKFrequentNumbers.Pair(entry.getValue(), entry.getKey()));
        }
        while(pq.size() > 0){
            answer.add(pq.poll().getElement());
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,1,3,2,2,4};
        System.out.println("Array after sorting based on frequency is : " + sortArray(arr));
    }
}
