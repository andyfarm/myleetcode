package com.andy.day4;

/**
 * 盛最多水的容器
 */
public class MaxArea0011 {

    public static void main(String[] args) {

        System.out.println("maxArea(new int[]{2, 4, 5, 7, 10}) = " + maxArea(new int[]{2, 4, 5, 7, 10}));


    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}