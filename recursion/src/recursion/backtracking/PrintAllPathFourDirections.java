package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathFourDirections {

    public static void main(String[] args) {
        int n = 3, m = 3;
        List<String> answer = new ArrayList<>();
        boolean [][] visited = new boolean[n][m];
        printAllPathFourDirections(0,0,n,m,"", answer, visited);
        System.out.println(answer);
    }

    private static void printAllPathFourDirections(int row, int col, int n, int m, String path, List<String> answer, boolean [][] visited){
        if(row == n-1 && col == m-1) {
            answer.add(path);
            return;
        }
        // if cell is already visited then simply return
        if(visited[row][col])
            return;
        visited[row][col] = true;
        if(row < n -1) {
            printAllPathFourDirections(row + 1, col, n, m,path + "D", answer, visited);
        }
        if(col < m - 1) {
            printAllPathFourDirections(row, col + 1, n, m,path + "R", answer, visited);
        }
        if(row > 0) {
            printAllPathFourDirections(row - 1, col, n, m,path + "U", answer, visited);
        }
        if(col > 0) {
            printAllPathFourDirections(row, col - 1, n, m, path + "L", answer, visited);
        }
        // backtrack
        visited[row][col] = false;
    }
}
