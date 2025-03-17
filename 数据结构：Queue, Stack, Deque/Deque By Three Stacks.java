public class Solution {
    private Deque<Integer> left;
    private Deque<Integer> right;
    private Deque<Integer> buffer;

    public Solution() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void offerFirst(int element) {
        left.offerFirst(element);
    }

    public void offerLast(int element) {
        right.offerLast(element);
    }

    public Integer pollFirst() {
        if (!left.isEmpty()) {
            return left.pollFirst();
        }
        if (!right.isEmpty()) {
            balanceRightToLeft();
            return left.pollFirst();
        }
        return null;
    }

    public Integer pollLast() {
        if (!right.isEmpty()) {
            return right.pollLast();
        }
        if (!left.isEmpty()) {
            balanceLeftToRight();
            return right.pollLast();
        }
        return null;
    }

    public Integer peekFirst() {
        if (!left.isEmpty()) {
            return left.peekFirst();
        }
        if (!right.isEmpty()) {
            balanceRightToLeft();
            return left.peekFirst();
        }
        return null;
    }

    public Integer peekLast() {
        if (!right.isEmpty()) {
            return right.peekLast();
        }
        if (!left.isEmpty()) {
            balanceLeftToRight();
            return right.peekLast();
        }
        return null;
    }

    public int size() {
        return left.size() + right.size();
    }

    public boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }

    // Helper methods to balance the queues properly
    private void balanceRightToLeft() {
        int mid = right.size() / 2;
        for (int i = 0; i < mid; i++) {
            buffer.offerFirst(right.pollLast());
        }
        while (!right.isEmpty()) {
            left.offerFirst(right.pollLast());
        }
        while (!buffer.isEmpty()) {
            right.offerLast(buffer.pollFirst());
        }
    }

    private void balanceLeftToRight() {
        int mid = left.size() / 2;
        for (int i = 0; i < mid; i++) {
            buffer.offerFirst(left.pollFirst());
        }
        while (!left.isEmpty()) {
            right.offerLast(left.pollFirst());
        }
        while (!buffer.isEmpty()) {
            left.offerFirst(buffer.pollFirst());
        }
    }
}
