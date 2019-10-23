public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};

        for (Integer n : solution.findSubstring(s, words)) {
            System.out.println(n);
        }
    }
}
