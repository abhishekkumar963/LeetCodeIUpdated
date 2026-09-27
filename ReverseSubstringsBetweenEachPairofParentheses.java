/*

1190. Reverse Substrings Between Each Pair of Parentheses


You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.

*/


class Solution {
    public String reverseParentheses(String s) {
        StringBuilder stack = new StringBuilder();
      
        for (char currentChar : s.toCharArray()) {
            if (currentChar == ')') {
                StringBuilder reversedSegment = new StringBuilder();

                while (stack.charAt(stack.length() - 1) != '(') {
                    reversedSegment.append(stack.charAt(stack.length() - 1));
                    stack.deleteCharAt(stack.length() - 1);
                }
              
                stack.deleteCharAt(stack.length() - 1);
              
                stack.append(reversedSegment);
            } else {
                stack.append(currentChar);
            }
        }
      
        return stack.toString();
    }
}

