import java.util.Stack;
import java.util.Arrays;

class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}

// 2. The Main class to test it
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Define the test case
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        
        // Print the original array
        System.out.println("Temperatures: " + Arrays.toString(temperatures));
        
        // Call the method
        int[] result = solution.dailyTemperatures(temperatures);
        
        // Print the resulting wait times
        System.out.println("Days to wait: " + Arrays.toString(result));
    }
}
