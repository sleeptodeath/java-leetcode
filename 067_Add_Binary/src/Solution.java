
public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int lenA = a.length(), lenB = b.length();
        String x = new StringBuilder(a).reverse().toString();
        String y = new StringBuilder(b).reverse().toString();
        int i = 0;
        while (i < lenA && i < lenB) {
            sb.append((carry+(x.charAt(i)-'0') + (y.charAt(i)-'0')) % 2);
            carry = (carry+(x.charAt(i)-'0') + (y.charAt(i)-'0')) / 2;
            i++;
        }
        while (i < lenA) {
            sb.append((carry+(x.charAt(i)-'0')) % 2);
            carry = (carry+(x.charAt(i)-'0')) / 2;
            i++;
        }
        while (i < lenB) {
            sb.append((carry+(y.charAt(i)-'0')) % 2);
            carry = (carry+(y.charAt(i)-'0')) / 2;
            i++;
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append((sum + carry) % 2);
            carry = (carry+ sum) / 2;
        }

        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
