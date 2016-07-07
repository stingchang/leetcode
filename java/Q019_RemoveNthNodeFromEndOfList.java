package com.leet.q011;

public class Q019_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head ==null || n ==0)
            return head;
        ListNode first = head, second = head;
        for(int i =0; i< n; i++){
            second = second.next;
        }
        // n = length
        if(second == null)
            return head.next;
        while(second.next!=null){
            first = first.next;
            second = second.next;
        }   
        first.next = first.next.next;
        return head;
    }
}
