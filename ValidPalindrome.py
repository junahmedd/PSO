# Valid Palindrome: Leetcode Problem 125
def isPalindrome(s:str) -> bool:
    filter = [c.lower() for c in s if c.isalnum()]
    return filter == filter[::-1]
s = input("Enter a string: ")
result = isPalindrome(s)
print(f"Result: {result}")
