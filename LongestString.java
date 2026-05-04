
// Longest Substring Without Repeating Characters: Leetcode Problem 3
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

class LongestString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        LongestString ls = new LongestString();
        System.out.println(ls.LengthLongestString(s));
        sc.close();

    }

    public int LengthLongestString(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(i));
            maxlen = Math.max(maxlen, i - left + 1);
        }
        return maxlen;
    }
}
