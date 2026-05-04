# Leetcode problem: Next Greater Element I (496)
class solu:
    def nextGreaterElement(self, nums1: list[int], nums2: list[int]) -> list[int]:
        stack = []
        next_greater = {}
        
        for num in nums2:
            while stack and stack[-1] < num:
                next_greater[stack.pop()] = num
            stack.append(num)
        
        return [next_greater.get(num, -1) for num in nums1]

# Test the function
if __name__ == "__main__":
    sol = solu()
    nums1 = [4, 1, 2]
    nums2 = [1, 3, 4, 2]
    result = sol.nextGreaterElement(nums1, nums2)
    print(f"Next greater elements: {result}")
