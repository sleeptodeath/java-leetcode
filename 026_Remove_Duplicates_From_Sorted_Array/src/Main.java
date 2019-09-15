
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int len = solution.removeDuplicates(arr);

        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }

    }
}
