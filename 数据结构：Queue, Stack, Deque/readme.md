# 队列、栈、双端队列（Queue, Stack, Deque）

| **数据结构** | **访问顺序** | **内存存储** | **Java 类** | **Java 接口** |
| --- | --- | --- | --- | --- |
| **队列（Queue）** | 先进先出（FIFO） | **链表** 或 **数组** | `LinkedList`, `PriorityQueue`, `ArrayDeque` | `Queue<E>` |
| **栈（Stack）** | 后进先出（LIFO） | **数组** 或 **链表** | `Stack`（基于 `Vector`，不推荐），`ArrayDeque`（推荐） | `Deque<E>` |
| **双端队列（Deque）** | 支持 FIFO 和 LIFO | **数组** 或 **链表** | `ArrayDeque`, `LinkedList` | `Deque<E>` |

## 队列（Queue）

| **方法** | **状态** | **行为** | **空队列返回值** |
| --- | --- | --- | --- |
| `offer(E e)` | 非满队列 | 安全添加元素 | 有界队列时返回 `false` |
| `poll()` | 非空队列 | 移除并返回头部元素 | 为空返回 `null` |
| `peek()` | 非空队列 | 返回头部元素但不移除 | 为空返回 `null` |

### 队列定义示例

```java
Queue<Integer> queue = new ArrayDeque<>();
Queue<Integer> queue = new LinkedList<>();
Queue<Integer> queue = new PriorityQueue<>();
```

## 栈 / 双端队列（Stack / Deque）

| **方法** | **描述** | **特殊返回值** | **异常抛出** |
| --- | --- | --- | --- |
| `offerFirst(E e)` | 在前端添加元素 | `false`（满） | 否 |
| `offerLast(E e)` | 在末端添加元素 | `false`（满） | 否 |
| `pollFirst()` | 移除并返回第一个元素 | `null`（空） | 否 |
| `pollLast()` | 移除并返回最后一个元素 | `null`（空） | 否 |
| `peekFirst()` | 获取第一个元素但不移除 | `null`（空） | 否 |
| `peekLast()` | 获取最后一个元素但不移除 | `null`（空） | 否 |

### 栈/双端队列定义示例

```java
Deque<Integer> stack = new ArrayDeque<>();
Deque<Integer> deque = new ArrayDeque<>();
```
