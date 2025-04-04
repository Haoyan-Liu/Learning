// head：指向queue的第一个元素
// tail：指向queue的最后一个元素
// head和tail在最后一次deque一定要重置到初始位置(-1,-1)
// 队列full的条件是(tail + 1) % size == head

class MyCircularQueue {
  private int[] queue;
  private int size;
  private int head;
  private int tail;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
      queue = new int[k];
      size = k;
      head = -1;
      tail = -1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
      if (isFull()) {
        return false;
        }
      if (isEmpty()) {
        head = 0;
      }
      tail = (tail + 1) % size;
      queue[tail] = value;
      return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
      if (isEmpty()) {
        return false;
      }
      if (head == tail) {
        head = -1;
        tail = -1;
      } else {
        head = (head + 1) % size;
      }
      return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
      if (isEmpty()) {
        return -1;
      }
      return queue[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
      if (isEmpty()) {
        return -1;
      }
      return queue[tail]; 
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % size == head;
    }
}

/*
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
