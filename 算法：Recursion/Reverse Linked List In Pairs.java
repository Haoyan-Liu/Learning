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
  public ListNode reverseInPairs(ListNode head) {
    // Write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    ListNode tail = reverseInPairs(head.next.next);
    ListNode newHead = head.next;
    head.next = tail;
    newHead.next = head;
    return newHead;
  }
}
