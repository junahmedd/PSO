// #303 LeetCode
public class SumArray {
    private int[] prefixSums;

    public SumArray(int[] nums) {
        prefixSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        System.out.println(prefixSums.length);
    }

    public int sumRange(int left, int right) {
        return prefixSums[right + 1] - prefixSums[left];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 }; // 0 1 3 6 10 15
        SumArray obj = new SumArray(nums);
        System.out.println(obj.sumRange(1, 2)); // 6
    }
}
