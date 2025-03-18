public class PrintZigZag {

    public static void solution(int n) {
        if(n == 0)
            return;
        System.out.println("pre "+n);
        solution(n-1);
        System.out.println("in "+n);
        solution(n-1);
        System.out.println("post "+n);
    }
    public static void main(String[] args) {
        solution(3);
    }
}
