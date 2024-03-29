package com.andy.day1;

/**
 * 给你两个非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * @author win
 */
public class AddTwoNumbers0002 {
    public static ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.data : 0;
            int n2 = l2 != null ? l2.data : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10, null);
            } else {
                tail.next = new ListNode(sum % 10, null);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry, null);
        }
        return head;
    }

    public static ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(),
                tail = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int n1 = l1 != null ? l1.data : 0;
            int n2 = l2 != null ? l2.data : 0;
            int sum = n1 + n2 + carry;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head.next;
    }
}
