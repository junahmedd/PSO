public class MaxAvg {
    public double MaxAverage(int[] nums, int k) {
        long currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        long maxSum = currentSum;
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        MaxAvg maxAvg = new MaxAvg();
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        double result = maxAvg.MaxAverage(nums, k);
        System.out.println("Maximum average: " + result);
    }
}
