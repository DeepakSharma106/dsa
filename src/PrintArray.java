public class PrintArray {

    public static void solution(int[] arr, int index) {
        if(index == 0) {
            return;
        }
        solution(arr, index-1);
        System.out.println(arr[index-1]);
    }

    public static void reverse(int[] arr, int index) {
        if(index == 0)
            return;
        System.out.println(arr[index-1]);
        reverse(arr, index-1);
    }
    public static void main(String[] args) {
        solution(new int[] {10, 11, 12, 13}, 4);
        System.out.println("====== reverse ==============");
        reverse(new int[] {10, 11, 12, 13}, 4);
    }
}
