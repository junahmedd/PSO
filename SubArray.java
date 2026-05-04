import java.util.HashMap;

public class SubArray {
    int count = 0;
    int prefixSum = 0;

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: prefix sum of 0 occurs once

        for (int num : nums) {
            prefixSum += num;

            // Check if there is a prefix sum that equals prefixSum - k
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Update the count of the current prefix sum in the map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubArray obj = new SubArray();
        int[] nums = { 1, 1, 1 };
        int k = 2;
        System.out.println(obj.subarraySum(nums, k)); // Output: 2
    }
}
