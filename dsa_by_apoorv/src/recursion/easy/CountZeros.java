package recursion.easy;

public class CountZeros {

    public static int countUtil(int n, int c){
        if(n == 0)
            return c;
        int rem = n % 10;
        if(rem == 0){
            return countUtil(n/10, c+1);
        }
        return countUtil(n/10, c);
    }

    public static int count(int n){
        return countUtil(n, 0);
    }

    public static void main(String[] args) {
        System.out.println(count(302830003));
    }
}
