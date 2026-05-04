public class SortedArray {
    public int[] twoSums(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int correctSums = nums[left] + nums[right];
            if (correctSums == target)
                return new int[] { left + 1, right + 1 };
            else if (correctSums < target)
                left++;
            else
                right--;
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int target = 3;
        SortedArray obj = new SortedArray();
        int[] result = obj.twoSums(nums, target);
        System.out.println("Indices: " + result[0] + " and " + result[1]);
    }
}
