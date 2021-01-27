package com.andy.day8;

/**
 * 不使用 乘法  除法 取模  计算
 *
 * @author win
 */
public class DivideWithDivide0029 {


    public static void main(String[] args) {
        System.out.println("div(Integer.MIN_VALUE, -1) = " + divide(Integer.MIN_VALUE, -1));
        System.out.println("div(Integer.MIN_VALUE, -1) = " + divide1(Integer.MAX_VALUE, 2));

    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            }
            return Integer.MAX_VALUE;

        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        long div = div(a, b);
        if (sign > 0) {
            return div > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) div;
        }
        return (int) -div;
    }

    public static long div(long a, long b) {
        if (a < b) {
            return 0;
        }
        long count = 1;
        long tb = b;
        while ((tb + tb) <= a) {
            count = count + count;
            tb = tb + tb;
        }
        return count + div(a - tb, b);
    }




    public static int divide1(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            }
            return Integer.MAX_VALUE;

        }
        int a = dividend;
        int b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = a > 0 ? -a : a;
        b = b > 0 ? -b : b;
        int div = div1(a, b);
        if (sign > 0) {
            return div;
        }
        return -div;
    }

    public static int div1(int a, int b) {
        if (a > b) {
            return 0;
        }
        int count = 1;
        int tb = b;
        while ((tb -a + tb) >= 0 ) {
            count = count + count;
            tb = tb + tb;
        }
        return count + div1(a - tb, b);
    }



    public int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 判断结果是不是负数
        boolean isNegative = (dividend ^ divisor) < 0 ? true : false;

        // 将除数和被除数都转为负数
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        int res = helper2(dividend, divisor);

        return isNegative ? -res : res;
    }

    private int helper2(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }

        int tmp = divisor;
        int count = 1;

        // 条件tmp + tmp < 0防止溢出
        while (tmp + tmp < 0 && dividend <= tmp + tmp) {
            count += count;
            tmp += tmp;
        }

        return count + helper2(dividend - tmp, divisor);
    }
}
