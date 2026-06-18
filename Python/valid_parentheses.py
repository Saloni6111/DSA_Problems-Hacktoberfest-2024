"""
Valid Parentheses Problem
Issue: #317 (saloni-jaiswal-dev/DSA_Problems)

Problem:
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
        determine if the input string is valid.

            A string is valid if:
                1. Open brackets must be closed by the same type of brackets.
                    2. Open brackets must be closed in the correct order.
                        3. Every close bracket has a corresponding open bracket of the same type.

                        Approach (Stack-based):
                            - Use a stack to track unmatched opening brackets.
                                - For each character in the string:
                                        * If it's an opening bracket, push it onto the stack.
                                                * If it's a closing bracket, check if it matches the top of the stack.
                                                          - If it matches, pop the stack.
                                                                    - If it doesn't match (or stack is empty), return False.
                                                                        - At the end, the string is valid only if the stack is empty.

                                                                        Time Complexity : O(n) — single pass through the string
                                                                        Space Complexity: O(n) — stack can hold at most n/2 brackets
                                                                        """


def is_valid(s: str) -> bool:
      stack = []
      matching = {')': '(', '}': '{', ']': '['}

    for char in s:
              if char in '({[':
                            stack.append(char)
elif char in ')}]':
            if not stack or stack[-1] != matching[char]:
                              return False
                          stack.pop()

    return len(stack) == 0


if __name__ == "__main__":
      test_cases = [
                ("()", True),
                ("()[]{}", True),
                ("(]", False),
                ("([)]", False),
                ("{[]}", True),
                ("", True),
                ("{", False),
      ]

    print("Valid Parentheses — Test Results")
    print("-" * 40)
    for s, expected in test_cases:
              result = is_valid(s)
              status = "PASS" if result == expected else "FAIL"
              print(f"[{status}] is_valid({s!r}) = {result} (expected {expected})")
      
