import java.util.HashSet;
public class LongestRepeatingChian {
    public int longestRepeating(String s) {
        int n = s.length();
        int left = 1, right = n - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasRepeatingSubstring(s, mid)) {
                result = mid; // Update result if a repeating substring of length mid is found
                left = mid + 1; // Try for a longer substring
            } else {
                right = mid - 1; // Try for a shorter substring
            }
        }

        return result;
    }

    private boolean hasRepeatingSubstring(String s, int length) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - length; i++) {
            String substring = s.substring(i, i + length);
            if (seen.contains(substring)) {
                return true; // Found a repeating substring
            }
            seen.add(substring);
        }
        return false; // No repeating substring of the given length found
    }

    public static void main(String[] args) {
        LongestRepeatingChian solution = new LongestRepeatingChian();
        String s = "abcabc";
        int result = solution.longestRepeating(s);
        System.out.println("Longest repeating substring length: " + result);
    }
}
