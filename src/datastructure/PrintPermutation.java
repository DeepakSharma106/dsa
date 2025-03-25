package datastructure;

public class PrintPermutation {

    public static void solution(String input, String asf) {
        if(input.length() == 0) {
            System.out.print(asf+" ");
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String remaining = input.substring(0, i) + input.substring(i+1);
            solution(remaining, asf+ch);
        }
    }

    public static void main(String[] args) {
        solution("abcd", "");
    }
}
