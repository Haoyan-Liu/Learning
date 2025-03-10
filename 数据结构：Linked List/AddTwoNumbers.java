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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Write your solution here
    int val = 0;
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    while (l1 != null || l2 != null || val != 0) {
      if ( l1 != null) {
        val += l1.value;
        l1 = l1.next;
      }
      if ( l2 != null) {
        val += l2.value;
        l2 = l2.next;
      }
      int num = val % 10;
      val = val / 10;
      cur.next = new ListNode(num);
      cur = cur.next;
    }
    return dummy.next;
  }
}
