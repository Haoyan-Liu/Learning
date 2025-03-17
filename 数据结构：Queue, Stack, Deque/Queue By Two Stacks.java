public class Solution {
  private LinkedList<Integer> in = new LinkedList<Integer>();
  private LinkedList<Integer> out = new LinkedList<Integer>();
  public Solution() {
    // Write your solution here.
  }
  
  public Integer poll() {
    if (!out.isEmpty()) {
      return out.poll();
    } else {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
      return out.poll();
    }
  }
  
  public void offer(int element) {
    in.push(element);
  }
  
  public Integer peek() {
    if (!out.isEmpty()) {
      return out.peek();
    } else {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
      return out.peek();
    }
  }
  
  public int size() {
    return in.size() + out.size();
  }
  
  public boolean isEmpty() {
    if (in.size() == 0 && out.size() == 0) {
      return true;
    } else {
      return false;
    }
  }
}
