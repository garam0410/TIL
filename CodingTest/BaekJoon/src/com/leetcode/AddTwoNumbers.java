package com.leetcode;

import java.util.Arrays;

public class AddTwoNumbers {
    public static void main(String[] args){

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        //new Solution().addTwoNumbers();
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution{

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            StringBuilder num1 = new StringBuilder();
            StringBuilder num2 = new StringBuilder();

            while(l1.next !=null){
                num1.append(l1.val);
                l1 = l1.next;
            }
            while(l2.next !=null){
                num1.append(l2.val);
                l2 = l2.next;
            }

            int sum = Integer.parseInt(String.valueOf(num1.reverse())) + Integer.parseInt(String.valueOf(num2.reverse()));

            String[] answerString = new StringBuilder(String.valueOf(sum)).reverse().toString().split("");

            ListNode answer = null;
            ListNode nextNode = null;
            ListNode checkNode = null;

            for(int i = 0; i<answerString.length;i++){

                if(i == 0) {
                    answer = new ListNode(Integer.parseInt(answerString[i]), new ListNode());
                }
                else if(i==1){
                    nextNode = new ListNode(Integer.parseInt(answerString[i]), new ListNode());
                    checkNode = nextNode.next;
                }
                else{
                    checkNode.val = Integer.parseInt(answerString[i]);
                    checkNode = checkNode.next;
                }
            }

            answer.next = nextNode;

            return answer;
        }
    }
}
