package recursion.easy;

public class Reverse {

    public static int reverse(int num){
        return reverseUtil(num, 0);
    }

    public static int reverseUtil(int num, int rev){
        if(num == 0){
            return rev;
        }
        return reverseUtil(num/10, rev * 10 + num % 10);
    }

    public static void main(String[] args) {
        int num = 1234;
        System.out.println(reverse(num));
    }
}
