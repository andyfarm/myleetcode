package com.andy.day7;

import com.andy.day1.ListNode;

/**
 * 交换相邻的两个节点，进行实际的交换，不是只改变　值
 *
 * @author andy
 */
public class SwitchTwoNode0024 {

    public static ListNode switchTwo(ListNode head) {
        if (head != null || head.next != null) {
            return head;
        }
        ListNode next = head.next;
        head.next = switchTwo(next.next);
        next.next = head;
        return next;
    }


    public static ListNode switchTwo1(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode next1 = temp.next;
            ListNode next2 = temp.next.next;
            temp.next = next2;
            next1.next = next2.next;
            next2.next = next1;
            temp = next1;
        }
        return dummyHead.next;
    }


}
