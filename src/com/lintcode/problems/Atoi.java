package com.lintcode.problems;

/**
 * Implement function atoi to convert a string to an integer.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * Example
 * Example 1
 * Input: "10"
 * Output: 10
 * 
 * Example 2
 * Input: "1"
 * Output: 1
 * 
 * Example 3
 * Input: "123123123123123"
 * Output: 2147483647
 * Explanation: 123123123123123 > INT_MAX, so we return INT_MAX
 * 
 * Example 4
 * Input: "1.0"
 * Output: 1
 * Explanation: We just need to change the first vaild number
 * 
 */
public class Atoi {

    public int atoi(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();

        if (str.length() == 0) {
            return 0;
        }

        int index = 0;
        int sign = 1;
        if (str.charAt(0) == '+') {
            index++;
        } else if(str.charAt(0) == '-') {
            index++;
            sign = -1;
        }

        int result = 0;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            int digit = str.charAt(index++) - '0';
            if (result > Integer.MAX_VALUE / 10 || 
                    (result == Integer.MAX_VALUE / 10 && digit >= 8)) {
                return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            } else {
                result = result * 10 + digit;
            }
        }

        return sign * result;
    }
}
