import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WildcardMatching {
    // public boolean isMatch(String s, String p) {
    // boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    // dp[0][0] = true;

    // for (int i = 1; i <= p.length(); i++) {
    // dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 1];
    // }

    // for (int i = 1; i <= s.length(); i++) {
    // for (int j = 1; j <= p.length(); j++) {
    // if (p.charAt(j - 1) != '*') {
    // dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) ||
    // p.charAt(j - 1) == '?');
    // } else {
    // dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
    // }
    // }
    // }
    // return dp[s.length()][p.length()];
    // }

    // public boolean isMatch(String s, String p) {
    //     boolean[] dp = new boolean[p.length() + 1];
    //     dp[0] = true;
    //     for (int i = 1; i <= p.length(); i++) {
    //         dp[i] = p.charAt(i - 1) == '*' && dp[i - 1];
    //     }
    //     for (int i = 1; i <= s.length(); i++) {
    //         boolean prev = dp[0], cur = false;
    //         dp[0] = false;
    //         for (int j = 1; j <= p.length(); j++) {
    //             cur = dp[j];
    //             if (p.charAt(j - 1) != '*') {
    //                 dp[j] = prev && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
    //             } else {
    //                 dp[j] = cur || prev || dp[j - 1];
    //             }
    //             prev = cur;
    //         }
    //     }
    //     return dp[p.length()];
    // }

    public boolean isMatch(String s, String p) {
        int star = -1, ss = 0;
        int i = 0, j = 0;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                star = j++;
                ss = i;
            } else if (star != -1) {
                j = star + 1;
                i = ++ss;
            } else
                return false;
        }
        while (j < p.length()) {
            if (p.charAt(j) != '*')
                return false;
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) throws FileNotFoundException {

        File infile = new File("test.txt");

        Scanner sc = new Scanner(infile);
        String s = new String();
        String p = new String();

        s = sc.next();
        p = sc.next();

        WildcardMatching instant = new WildcardMatching();

        boolean res = instant.isMatch(s, p);

        System.out.println(s + "--" + p + "  res:" + res);
        sc.close();
    }
}
