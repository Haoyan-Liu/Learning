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
  public boolean isPalindrome(ListNode head) {
    // Write your solution here
    if (head == null || head.next == null) {
      return true;
    }
    ListNode mid = middle(head);
    ListNode rev = reverse(mid.next);
    mid.next = null;
    while (head != null && rev != null) {
      if (head.value != rev.value) {
        return false;
      }
      else {
        head = head.next;
        rev = rev.next;
      }
    }
    return true;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  private ListNode middle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
