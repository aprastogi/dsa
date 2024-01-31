package recursion.medium;

public class CountPathFromSourceToDestination {

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(countPath(n-1, m-1));
    }

    private static int countPath(int n, int m) {
        // If we are on a first row or first column there will be only 1 way to come to destination
        if(n == 0 || m == 0)
            return 1;
        // sum the path from come down and right to get the output for current cell
        return countPath(n-1,m) + countPath(n,m-1);
    }
}
