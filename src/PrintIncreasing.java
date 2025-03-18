public class PrintIncreasing {

    public static void printIncreasing(int n) {
        if(n == 0) {
            return;
        }

        printIncreasing(n-1);
        System.out.print(n+" ");
    }

    public static void printDecreasing(int n) {
        if(n == 0)
            return;
        System.out.print(n+" ");
        printDecreasing(n-1);
    }

    public static void printIncreasingDecreasing(int n) {
        if(n == 0)
            return;
        System.out.print(n+" ");
        printIncreasingDecreasing(n-1);
        System.out.print(n+" ");
    }

    public static int factorial(int n) {
        if(n == 1)
            return n;
        return factorial(n-1) * n;
    }

    public static int powerLinear(int base, int power) {
        if(power == 0)
            return 1;
        int result = powerLinear(base, power-1) * base;
        return result;
    }
    public static void main(String[] args) {
        printIncreasing(5);
        System.out.println();
        printDecreasing(5);
        System.out.println();
        printIncreasingDecreasing(5);
        System.out.println();
        int result = factorial(4);
        System.out.println(result);
        System.out.println(powerLinear(3,3));
    }
}
