package datastructure;

public class PrintSubsequences {

    public static void solution(String input) {
        printSS(input, "");
    }

    private static void printSS(String input, String asf) {
        if(input.length() == 0) {
            System.out.print(asf+" ");
            return;
        }

        char ch = input.charAt(0);
        String rem = input.substring(1);

        printSS(rem, asf+ch);
        printSS(rem, asf);

    }
    public static void main(String[] args) {
        solution("abc");
    }
}
