package datastructure;

import java.util.Arrays;
import java.util.Scanner;

public class AllIndices {

    public static int[] solution1(int[] array, int target) {
        return solution(array, 0, target, 0);
    }
    private static int[] solution(int[] array, int index, int target, int counter) {

        if(array.length == index) {
            int[] result = new int[counter];
            return result;
        }

        if(array[index] == target) {
            // increment the counter
            counter = counter + 1;
        }

        int[] result = solution(array, index+1, target, counter);
        if(array[index] == target) {
            result[counter-1] = index;
        }

        return result;

    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter length of array");
        int len = scanner.nextInt();
        System.out.println("enter array items");
        int[] input = new int[len];
        for (int i = 0; i < input.length; i++) {
             input[i] = Integer.parseInt(scanner.next());
        }
        System.out.println(Arrays.toString(input));

        int[] result = solution1(input, 5);
        System.out.println(Arrays.toString(result));
    }
}
