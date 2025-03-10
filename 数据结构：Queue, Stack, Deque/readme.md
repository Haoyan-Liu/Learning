# Queue, Stack, Deque

| **Data Structure** | **Access Order** | **Memory Storage** | **Java Class** | **Java Interface** |
| --- | --- | --- | --- | --- |
| **Queue** | FIFO (First In, First Out) | **Linked List** or **Array** | `LinkedList`, `PriorityQueue`, `ArrayDeque` | `Queue<E>` |
| **Stack** | LIFO (Last In, First Out) | **Array** or **Linked List** | `Stack` (based on `Vector`, not recommended), `ArrayDeque` (recommended) | `Deque<E>` |
| **Deque** | Supports FIFO & LIFO | **Array** or **Linked List** | `ArrayDeque`, `LinkedList` | `Deque<E>` |

## Queue

| **Method** | **Queue/Deque State** | **Behavior** | **Return Value if Empty** |
| --- | --- | --- | --- |
| `offer(E e)` | Non-full queue | Adds element safely | Returns `false` if full (for bounded queues) |
| `poll()` | Non-empty queue | Removes and returns head element | Returns `null` if empty |
| `peek()` | Non-empty queue | Returns head element without removing | Returns `null` if empty |

### How to define a queue

```java
Queue<Integer> queue = new ArrayDeque<>();
Queue<Integer> queue = new LinkedList<>();
Queue<Integer> queue = new PriorityQueue<>();
```

## Stack / Deque

| **Method** | **Description** | **Returns Special Value?** | **Throws Exception?** |
| --- | --- | --- | --- |
| `offerFirst(E e)` | Adds an element at the front | `false` if full | No |
| `offerLast(E e)` | Adds an element at the end | `false` if full | No |
| `pollFirst()` | Removes and returns the first element | `null` if empty | No |
| `pollLast()` | Removes and returns the last element | `null` if empty | No |
| `peekFirst()` | Retrieves the first element without removing | `null` if empty | No |
| `peekLast()` | Retrieves the last element without removing | `null` if empty | No |

### How to define a stack/queue

```java
Deque<Integer> stack = new ArrayDeque<>();
Deque<Integer> deque = new ArrayDeque<>();
```
