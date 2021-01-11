package com.andy.dayone;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * @author win
 */
public class TwoSum0001 {


    /**
     * 暴力破解法  双层循环
     * O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 采用HashMap 一次遍历就可以找到结果
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(temp)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
