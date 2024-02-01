package recursion.medium;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;

public class PrintUniquePath {

    public static void main(String[] args) {
        int n = 3, m = 3;
        List<String> answer = new ArrayList<>();
        printUniquePath(0,0,n-1,m-1, "", answer);
        System.out.println(answer);
    }

    private static void printUniquePath(int i, int j, int n, int m, String output,  List<String> answer) {
        if(i == n && j == m){
            answer.add(output);
            return;
        }

        if(i < n){
            printUniquePath(i+1, j, n, m, "D" + output, answer);
        }

        if(j < m){
            printUniquePath(i, j+1, n,m, "R" + output, answer);
        }
    }
}
