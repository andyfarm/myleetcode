package com.andy.day9;

/**
 * 查询插入的位置   有序数组  相等则返回相等的位置
 * @author win
 */
public class SearchInsertPosition0035 {

    public static void main(String[] args) {
        System.out.println("searchInsert(new int[] {1, 2, 4, 6, 9}, 4) = " + searchInsert(new int[]{1, 2, 4, 6, 9}, 10));
    }
    public static int searchInsert(int[] nums , int target) {
        int n = nums.length;
        int left =0 ;
        int right = n - 1;
        int ans = n;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }

        }
        return ans;
    }
}
