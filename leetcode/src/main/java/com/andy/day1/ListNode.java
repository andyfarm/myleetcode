package com.andy.day1;

public class ListNode {

    public int data;
    public ListNode next;

    public ListNode() {
    }
    public ListNode(int data) {
        new ListNode(data, null);
    }
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }


}