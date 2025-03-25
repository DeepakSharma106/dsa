package datastructure;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {

    public static List<String> solution(String input) {

        if(input.length() == 0) {
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        List<String> mres = new ArrayList<>();
        char ch = input.charAt(0);
        // remaining string
        String remainString = input.substring(1);
        List<String> result = solution(remainString);
        for(String str: result) {
            mres.add(str+"*");
            mres.add(str+ch);
        }
        return mres;
    }

    public static void main(String[] args) {
        String input = "abc";
        List<String> answer = solution(input);
        System.out.println(answer);
    }
}
