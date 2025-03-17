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
  public ListNode insert(ListNode head, int value) {
    // Write your solution here
    ListNode newNode = new ListNode(value);
    if (head == null) {
      return newNode;
    }
    if (newNode.value < head.value) {
      newNode.next = head;
      return newNode;
    }
    ListNode cur = head;
    ListNode nxt = cur.next;
    while (nxt != null) {
      if (cur.value <= value && nxt.value >= value) {
        cur.next = newNode;
        newNode.next = nxt;
        return head;
      }
      else {
      cur = nxt;
      nxt = nxt.next;
      }
    }
    cur.next = newNode;
    return head;
  }
}
