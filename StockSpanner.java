import java.util.Stack;

// 1. Your StockSpanner class
class StockSpanner {
    // Stack stores integer arrays: {price, span}
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        
        stack.push(new int[]{price, span});
        return span;
    }
}

// 2. The Main class to test it
public class Main {
    public static void main(String[] args) {
        // Initialize your object
        StockSpanner stockSpanner = new StockSpanner();
        
        // Define the sequence of incoming stock prices
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        
        System.out.println("Processing Prices:");
        
        // Feed the prices into the spanner one by one
        for (int price : prices) {
            int span = stockSpanner.next(price);
            
            // Print the result for each day
            System.out.println("Price: " + price + " \t-> Span: " + span);
        }
        
        /* 
         * Expected Output:
         * Processing Prices:
         * Price: 100   -> Span: 1
         * Price: 80    -> Span: 1
         * Price: 60    -> Span: 1
         * Price: 70    -> Span: 2  (70 is higher than 60, so it absorbs it)
         * Price: 60    -> Span: 1
         * Price: 75    -> Span: 4  (75 absorbs 60, 70, and the previous 60)
         * Price: 85    -> Span: 6  (85 absorbs 75, 80, and everything under them)
         */
    }
}
