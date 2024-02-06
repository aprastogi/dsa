package greedy;

/*
https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInOneRoom {

    static class Pair{
        int start, end;
        public Pair(int first, int second){
            this.start = first;
            this.end = second;
        }

        public int getEnd(){
            return end;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static List<Pair> nMeetingsInOneRoom(int[] start, int[] end) {
        int n = start.length;
        List<Pair> list = new ArrayList<>();
        List<Pair> answer = new ArrayList<>();
        // Store the previous meeting index
        int prevMeeting = 0;
        for(int i=0;i<n;i++){
            list.add(new Pair(start[i], end[i]));
        }
        // Sort the list as per the meeting end time
        list.sort(Comparator.comparingInt(Pair::getEnd));
        // add the 0th element to answer as this will be the first meeting being performed
        answer.add(new Pair(list.get(0).start, list.get(0).getEnd()));
        for(int i=1;i<n;i++){
            Pair prev = list.get(prevMeeting);
            Pair curr = list.get(i);
            // Check if current can be performed
            if(curr.start > prev.end){
                answer.add(new Pair(curr.start, curr.end));
                // set current meeting as the latest meeting happened
                prevMeeting = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] start = {1,3,0,5,8,5};
        int [] end = {2,4,6,7,9,9};
        System.out.println("Meetings which can be accommodated  are : " + nMeetingsInOneRoom(start, end));
    }
}
