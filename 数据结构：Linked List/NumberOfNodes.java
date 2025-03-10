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
  public int numberOfNodes(ListNode head) {
    // Write your solution here
    if (head == null) {
      return 0;
    }
    int cnt = 0;
    while (head != null) {
      cnt += 1;
      head = head.next;
    }
    return cnt;
  }
}
