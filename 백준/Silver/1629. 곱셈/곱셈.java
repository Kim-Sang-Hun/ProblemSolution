import java.util.Scanner;
public class Main {
    
    static long r;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int times = s.nextInt();
        r = s.nextLong();
        long result = pow(num, times);
        System.out.println(result);
    }
    
    public static long pow(long num, long times) {
        if (times == 1) {
            return num % r;
        }
        
        long temp = pow(num, times / 2);
        
        if (times % 2 == 1) {
            return temp * temp % r * num % r;
        } else {
            return temp * temp % r;
        }
    }
}