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
  public ListNode reorder(ListNode head) {
    // Write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    ListNode one = head;
    ListNode mid = findMidNode(head);
    ListNode two = mid.next;
    mid.next = null;
    ListNode reTwo = reverse(two);
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    while (one != null && reTwo != null) {
      cur.next = one;
      one = one.next;
      cur.next.next = reTwo;
      reTwo = reTwo.next;
      cur = cur.next.next;
    }
    if (one != null) {
      cur.next = one;
    }
    if (reTwo != null) {
      cur.next = reTwo;
    }
    return dummy.next;
  }

  private ListNode findMidNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode nxt = cur.next;
      cur.next = pre;
      pre = cur;
      cur = nxt;
    }
    return pre;
  }
}
