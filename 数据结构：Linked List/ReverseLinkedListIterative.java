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
  public ListNode reverse(ListNode head) {
    // Write your solution here
    if (head == null || head.next == null) {
      return head;
    }

    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode nxt = cur.next; // 先记录nxt 避免丢失后续链表
      cur.next = pre;
      pre = cur;
      cur = nxt;
    }
    return pre;
  }
}
