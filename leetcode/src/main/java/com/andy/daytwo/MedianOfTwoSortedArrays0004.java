package com.andy.daytwo;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * @author win
 */
public class MedianOfTwoSortedArrays0004 {
    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 5, 6, 9};
        int[] nums2 = new int[]{4, 10, 34, 100, 980};
        // System.out.println("getMedianOfTwoSortedArrays(nums1, nums2) = " + getMedianOfTwoSortedArrays(nums1, nums2));
        // System.out.println("getMedianOfTwoSortedArrays2(nums1,nums2) = " + getMedianOfTwoSortedArrays2(nums1, nums2));
        for (int i = 1; i < 10; i++) {
            System.out.println("getKth1(nums1, nums2,i) = " + getKth1(nums1, nums2, i));
        }
    }

    /**
     * 此算法为 O（m+n）
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double getMedianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0;
        int j = 0;
        while (count != (m + n)) {

            if (i == m) {
                while (j != n) {
                    result[count++] = nums2[j++];
                }
                break;
            }

            if (j == n) {
                while (i != m) {
                    result[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                result[count++] = nums1[i++];
            } else {
                result[count++] = nums2[j++];
            }

        }
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
        return count % 2 == 0 ? (result[count / 2 - 1] + result[count / 2]) / 2.00 : result[count / 2];
    }


    /**
     * 此算法为 O（m+n）
     * if (m+n) % 2 == 0
     * int a = (m+n) / 2
     * the middle = (order[a-1] + order[a]) / 2
     * else
     * int a = (m+n) / 2
     * the middle = order[a]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double getMedianOfTwoSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int a = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i < a / 2 + 1; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        return a % 2 == 0 ? (left + right) / 2.00 : right;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left)
                + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }


    /**
     * 二分查找 第 k 个数
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    private static int getKth1(int[] nums1, int[] nums2, int k) {
        int index1 = 0;
        int index2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int len = k / 2;
            int newIndex1 = Math.min(index1 + len, length1) - 1;
            int newIndex2 = Math.min(index2 + len, length2) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

}
