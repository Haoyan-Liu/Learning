// insert sort like
public class Solution {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    // Write your solution here.
    while (!s1.isEmpty()) {
      int temp = s1.pop();
      // Move elements from s2 back to s1 if they are greater than temp
      while (!s2.isEmpty() && s2.peek() > temp) {
        s1.push(s2.pop());
      }
      // Place temp in the correct position in s2
      s2.push(temp);
    }
    // Move elements back from s2 to s1 so that s1 is sorted in ascending order
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
  }
}
// select sort like
public class Solution {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    // Write your solution here.
    if (s1 == null || s1.size() <= 1) {
      return;
    }
    while (!s1.isEmpty()) {
      int min = Integer.MAX_VALUE;
      int cnt = 0;
      // step 1: compare cur value with min and find the global min offer it into the buffer s2
      while (!s1.isEmpty()) {
        int cur = s1.pollFirst();
        if (cur < min){
          min = cur;
          cnt = 1;
        } else if (cur == min) {
          cnt++;
        }
        s2.offerFirst(cur);
      }
      // step 2: put all element larger than min back into s1
      while(!s2.isEmpty() && s2.peekFirst() >= min) {
        int tmp = s2.pollFirst();
        if (tmp > min) {
          s1.offerFirst(tmp);
        }
      }
      // step 3: push corerct number of cur min into s2
      while (cnt != 0) {
        s2.offerFirst(min);
        cnt--;
      }
    }
    // step 4: move element back to s1 to have the min on s1's top
    while(!s2.isEmpty()) {
      s1.offerFirst(s2.pollFirst());
    }
  }
}
