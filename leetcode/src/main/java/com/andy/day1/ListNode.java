package com.andy.day1;

public class ListNode {

    public int data;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public static ListNode generateNodeList(int[] data) {
        if (data == null || data.length < 1) {
            throw new RuntimeException();
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int datum : data) {
            temp.next = new ListNode(datum);
            temp = temp.next;
        }
        return head.next;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.data);
        ListNode temp = this;
        while (temp.next != null) {
            sb.append(temp.next.data);
            temp = temp.next;
        }
        return sb.toString();
    }
}