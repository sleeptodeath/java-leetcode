
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0};
        int[] ret = solution.plusOne(arr);
        for (int i = 0; i < ret.length; i++)
            System.out.println(ret[i]);
//        System.out.println(solution.plusOne(arr));
    }
}
