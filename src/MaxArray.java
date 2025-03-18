public class MaxArray {

    public static int solution(int[] arr, int index){
        // base case
        if(index == arr.length) {
            return Integer.MIN_VALUE;
        }

        int max = solution(arr, index+1);
        int element = arr[index];
        if(element > max) {
            max = element;
        }

        return max;
    }

    public static void main(String[] args) {
        int result = solution(new int[] {10,34,12,55}, 0);
        System.out.println(result);
    }
}
