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
  public ListNode partition(ListNode head, int target) {
    // Write your solution here
    ListNode dummyOne = new ListNode(-1);
    ListNode dummyTwo = new ListNode(-1);
    ListNode curOne = dummyOne;
    ListNode curTwo = dummyTwo;

    while (head != null) {
      if (head.value < target) {
        curOne.next = head;
        curOne = curOne.next;
      }
      else {
        curTwo.next = head;
        curTwo = curTwo.next;
      }
      head = head.next;
    }
    curTwo.next = null;
    curOne.next = dummyTwo.next;
    return dummyOne.next;
  }
}
