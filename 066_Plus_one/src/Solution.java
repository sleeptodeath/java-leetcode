
public class Solution {

        //丑陋
//    public int[] plusOne(int[] digits) {
//        StringBuilder sb = new StringBuilder();
//        int carry = 0;
//        for (int i = digits.length-1; i >= 0; i--) {
//            if (i == digits.length-1) {
//                sb.append((digits[i] + 1 + carry) % 10);
//                carry = (digits[i] + 1 + carry) / 10;
//            }
//            else {
//                sb.append((digits[i] + carry) % 10);
//                carry = (digits[i] + carry) / 10;
//            }
//        }
//        if (carry > 0)
//            sb.append(1);
//        sb.reverse();
////        System.out.println(sb.toString());
//        int[] ret = new int[sb.length()];
//        for (int i = 0; i < ret.length; i++)
//            ret[i] = sb.charAt(i)-'0';
//        return ret;
//    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length-1; i >= 0; i--) {
           if (digits[i] == 9)
               digits[i] = 0;
           else {
               digits[i]++;
               return digits;
           }
        }
        int[] newint = new int[digits.length+1];
        newint[0] = 1;
        return newint;
    }
}
