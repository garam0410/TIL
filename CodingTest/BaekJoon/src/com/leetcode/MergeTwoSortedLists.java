package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeTwoSortedLists {
    public static void main(String[] args){
        //new Solution().mergeTwoLists();
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode answer = null;

            ArrayList<Integer> array = new ArrayList<Integer>();

            while(true){
                try{
                    if(l1.next != null){
                        array.add(l1.val);
                        l1 = l1.next;
                    }else{
                        array.add(l1.val);
                        break;
                    }
                }catch(Exception e){
                    break;
                }

            }

            while(true){
                try{
                    if(l2.next != null){
                        array.add(l2.val);
                        l2 = l2.next;
                    }else{
                        array.add(l2.val);
                        break;
                    }
                }catch(Exception e){
                    break;
                }

            }

            Collections.sort(array);
            //Collections.sort(array, Collections.reverseOrder());
            System.out.println(Arrays.toString(array.toArray()));

            for(int i = 0; i<array.size(); i++){
                ListNode newNode = new ListNode(array.get(i));
                if(answer == null){
                    answer = newNode;
                }else{
                    ListNode tmpNode = answer;
                    while(tmpNode.next != null){
                        tmpNode = tmpNode.next;
                    }
                    tmpNode.next = newNode;
                }
            }

            return answer;
        }
    }
}
