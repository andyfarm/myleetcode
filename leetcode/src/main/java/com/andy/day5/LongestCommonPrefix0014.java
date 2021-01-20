package com.andy.day5;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀
 * strs = ["flower","flow","flight"]
 *
 *   横向扫描
 *   纵向扫描
 *   分治法
 *   二分查找
 * @author win
 */
public class LongestCommonPrefix0014 {


    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "floght"};
        System.out.println("longestCommonPrefix(strs) = " + longestCommonPrefix1(strs));

    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }


    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && (str1.charAt(index) == str2.charAt(index))) {
            index++;
        }

        return str1.substring(0, index);
    }



    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


}
