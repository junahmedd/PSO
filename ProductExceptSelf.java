import java.util.Arrays;
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] Result = new int[n];
        Result[0] = 1; 
        for (int i = 1; i < n; i++) {
            Result[i] = Result[i - 1] * nums[i - 1]; 
        }
        int rightProduct = 1; 
        for (int i = n - 1; i >= 0; i--) {
            Result[i] *= rightProduct; 
            rightProduct *= nums[i]; 
        }
        return Result;
    }

    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();
        int[] nums = { 1, 2, 3, 4 };
        System.out.print(Arrays.toString(solution.productExceptSelf(nums)));
    }
}
