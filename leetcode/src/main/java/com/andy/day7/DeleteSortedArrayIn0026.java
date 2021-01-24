package com.andy.day7;

/**
 * 删除数组重复元素　　原地算法
 *
 * @author andy
 */
public class DeleteSortedArrayIn0026 {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 5, 5, 32, 87, 87, 192};
        System.out.println("deleteSortedArray(nums) = " + deleteSortedArray(nums));

    }

    public static int deleteSortedArray(int[] nums) {
        int i = 0;
        int j = 1;
        for (; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
