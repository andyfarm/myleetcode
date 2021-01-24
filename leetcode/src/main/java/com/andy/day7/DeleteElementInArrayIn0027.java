package com.andy.day7;

/**
 * 原地移除　和　ｖａｌ　相等的元素
 *
 * @author andy
 */
public class DeleteElementInArrayIn0027 {

    public static int deleteEleArray(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }

    public static int deleteEleArray1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;

    }
}
