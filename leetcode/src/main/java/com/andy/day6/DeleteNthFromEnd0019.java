package com.andy.day6;

import com.andy.day1.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表的倒数第 n 个节点   节点从1开始
 * @author win
 */
public class DeleteNthFromEnd0019 {


    /**
     * 使用栈 先 push  然后pop 出 n 个元素  栈顶就是 要删除节点的前驱节点
     * 也可以先获取 链表长度  再
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    /**
     *
     * 快慢指针   第一个指针先移动 n  然后同时移动
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndOne(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
