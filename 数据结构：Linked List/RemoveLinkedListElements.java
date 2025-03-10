/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    // Write your solution here
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = head;
    while (cur != null) {
      if (cur.value != val) {
        pre = cur;
        cur = cur.next;
      }
      else {
        pre.next = cur.next;
        cur = cur.next;
      }
    }
    return dummy.next; 
  }
}
