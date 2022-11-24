package com.andy.day1;

public class Day1Main {
    public static void main(String[] args) {
        ListNode listNode1 = ListNode.generateNodeList(new int[]{1, 2, 3, 4});
        System.out.println("listNode1 = " + listNode1);
        ListNode listNode2 = ListNode.generateNodeList(new int[]{1, 2, 3, 4, 5});
        ListNode ansNode = AddTwoNumbers0002.addTwoNumbers02(listNode1, listNode2);
        System.out.println("ansNode = " + ansNode);

    }
}
