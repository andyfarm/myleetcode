package com.andy.day8;

import java.util.Arrays;

/**
 * 找到下一个字典序
 *
 * @author win
 */
public class NextPermutation0031 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 9, 6};
        nextPermutation(nums);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i > 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int i) {
        int left = i;
        int right = nums.length -1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
