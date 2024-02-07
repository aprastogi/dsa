package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
https://www.geeksforgeeks.org/job-sequencing-problem/
 */
public class JobSequencing {

    static class Job{
        char id;
        int deadline, profit;

        public Job(char id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        public int getProfit(){
            return profit;
        }

        public int getDeadline(){
            return deadline;
        }
    }

    public static char [] jobSequencingWithMaxProfit(List<Job> jobs){
        // sort the jobs list in decreasing order of profit
        jobs.sort(Comparator.comparingInt(Job::getProfit).reversed());
        // get the maximum deadline from jobs list

        int maxDeadline = jobs.stream().max(Comparator.comparingInt(Job::getDeadline)).map(Job::getDeadline).orElse(0);
        char [] answer = new char[maxDeadline];
        Arrays.fill(answer, '0');
        for (Job job : jobs) {
            int currentJobDeadline = job.deadline;
            // Decrease the currentJobDeadLine by 1 to adjust with 1-based indexing
            currentJobDeadline--;
            // decrement the currentJobDeadLine till the point we don't find a proper day to execute the job
            while (currentJobDeadline >= 0 && answer[currentJobDeadline] != '0') {
                currentJobDeadline--;
            }
            // check if we are not executing the job on wrong day
            if (currentJobDeadline >= 0 && answer[currentJobDeadline] == '0') {
                answer[currentJobDeadline] = job.id;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        List<Job> list = new ArrayList<>();
        list.add(new Job('a', 2, 100));
        list.add(new Job('b', 1, 19));
        list.add(new Job('c', 2, 27));
        list.add(new Job('d', 1, 25));
        list.add(new Job('e', 3, 15));
        System.out.println(Arrays.toString(jobSequencingWithMaxProfit(list)));
    }
}
