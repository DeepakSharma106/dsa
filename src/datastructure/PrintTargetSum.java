package datastructure;

public class PrintTargetSum {

    public static void solution(int[] array, int target) {
        printTarget(array, 0, target, "", 0);
    }

    private static void printTarget(int[] array, int index, int target, String asf, int sso) {
        if(array.length == index) {
            if(sso == target) {
                System.out.println(asf);
                return;
            } else {
                return;
            }
        }

        if(sso > target) {
            return;
        }
        // can come or can not come
        printTarget(array, index+1, target, asf +" "+array[index], sso + array[index]);
        printTarget(array, index+1, target, asf, sso);
    }
    public static void main(String[] args) {
        int[] array = {10,20,30,40,50};
        solution(array, 70);
    }
}
