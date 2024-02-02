package recursion.easy;

public class SumOfDigits {
    public static int sumOfDigits(int num){
        return sumOfDigitsUtil(num, 0);
    }

    public static int sumOfDigitsUtil(int num, int sum){
        if(num == 0){
            return sum;
        }
        return sumOfDigitsUtil(num/10, sum + num % 10);
    }

    public static void main(String[] args) {
        int num = 1234;
        System.out.println(sumOfDigits(num));
    }
}
