class Solution {
    private Queue<Integer> q;
    /** Initialize your data structure here. */
    public Solution() {
       q = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
      if (q.isEmpty()) {
        return null;
        }
      int size = q.size();
      while (--size != 0) {
        q.offer(q.poll());
      } 
      return q.poll(); 
    }

    /** Get the top element. */
    public Integer top() {
      if (q.isEmpty()) {
        return null;
        }
      int res = pop();
      q.offer(res);
      return res;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
      return q.isEmpty();
    }
}
