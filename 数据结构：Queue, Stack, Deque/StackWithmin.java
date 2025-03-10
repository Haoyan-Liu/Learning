public class Solution {
  private Deque<Integer> stack;
  private Deque<Pair> minStack;
  public Solution() {
    stack = new LinkedList<>();
    minStack = new LinkedList<>();
  }
  
  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    if (!minStack.isEmpty() && stack.size() == minStack.peek().size) { // 不看empty会造成npe
      minStack.pop();
    }
    return stack.pop();
  }
  
  public void push(int element) {
    stack.push(element);
    if (minStack.isEmpty() || element < minStack.peek().value) { // 不看empty会造成npe
      minStack.push(new Pair(element, stack.size()));

    }
  }
  
  public int top() {
    return stack.isEmpty() ? -1: stack.peek(); // 不看empty会造成npe
  }
  
  public int min() {
    return stack.isEmpty() ? -1: minStack.peek().value; // 不看empty会造成npe
  }
}

class Pair {
  int value;
  int size;

  public Pair(int value, int size) {
        this.value = value;
        this.size = size;
    }
}
