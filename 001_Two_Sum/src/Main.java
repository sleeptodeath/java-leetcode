

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] ret = solution.twoSum(arr, target);
        System.out.println(ret[0] + "," + ret[1]);
    }
}
