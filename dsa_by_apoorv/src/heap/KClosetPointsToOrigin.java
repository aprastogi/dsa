package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosetPointsToOrigin {

    static class Pair{
        int distance;
        int [] points;

        public Pair(int distance, int [] points){
            this.distance = distance;
            this.points = points;
        }

        public int getDistance(){
            return distance;
        }

        public int [] getPoints(){
            return points;
        }
    }

    public static List<List<Integer>> kClosetPointsToOrigin(int [][] arr, int k){
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getDistance).reversed());
        for(int [] points: arr){
            // Add distance between the points to priority queue
            pq.add(new Pair((points[0] * points[0] + points[1] * points[1]),points));
            if(pq.size() > k){
                pq.poll();
            }
        }
        for(int i=0;i<pq.size();i++){
            answer.add(new ArrayList<>());
        }
        int ctr = 0;
        while(pq.size() > 0){
            int [] points = pq.poll().getPoints();
            answer.get(ctr).add(points[0]);
            answer.get(ctr).add(points[1]);
            ctr++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int [][] arr = {{1,3},{-2,2},{5,8},{0,1}};
        int k = 2;
        System.out.println("K Closet points to origin are : " + kClosetPointsToOrigin(arr, k));
    }
}
