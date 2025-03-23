package dynamicProgramming;

public class Fibonacci {


    public static int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        System.out.println("hello "+n);
        int result = fib(n-1) + fib(n-2);
        return result;


    }

    public static int fibMemorized(int n, int[] array) {
        if(n == 0 || n == 1) {
            return n;
        }

        if(array[n] != 0) {
            return array[n];
        }

        System.out.println("Hello "+n);
        int x = fibMemorized(n-1, array);
        int y = fibMemorized(n-2, array);
        int ans = x + y;
        array[n] = ans;
        return ans;
    }

    public static void main(String[] args) {
       // int answer = fib(10);
        int[] array = new int[11];
        int answer = fibMemorized(10, array);
        System.out.println(answer);
    }
}
