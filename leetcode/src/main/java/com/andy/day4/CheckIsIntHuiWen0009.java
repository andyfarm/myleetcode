package com.andy.day4;

/**
 * 检查整数是否回文
 * @author win
 */
public class CheckIsIntHuiWen0009 {

    public static void main(String[] args) {
        System.out.println("isPalindrome(1234321) = " + isPalindrome(1234321));

    }


    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
