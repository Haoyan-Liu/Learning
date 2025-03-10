# 堆（Heap）和优先队列（Priority Queue）

### **1. `offer(e)` 的时间复杂度** `O(log n)`

#### **过程**
1. **插入新元素到堆的末尾**（保证完全二叉树结构）。
2. **向上调整（Heapify Up）**：
    - 比较新元素和父节点，若不满足堆的性质，则交换。
    - 继续向上调整，直到满足堆的性质或达到根节点。

### **2. `peek()` 的时间复杂度** `O(1)`

- 直接访问 **堆顶元素（最小/最大元素）**。
- 堆顶元素存储在 `arr[0]`，直接返回。

### **3. `poll()` 的时间复杂度** `O(log n)`

#### **过程**
1. **取出堆顶元素**。
2. **用堆的最后一个元素替换堆顶**。
3. **向下调整（Heapify Down）**：
    - 比较新根节点与其子节点，找到最小/最大值进行交换。
    - 继续向下调整，直到满足堆的性质。

---

### **对象堆排序（Heap with Objects）**

#### **方法 1：让对象实现 `Comparable<T>`**
```java
class Cell implements Comparable<Cell> {
    int row, col, value;
    public Cell(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
    @Override
    public int compareTo(Cell other) {
        return Integer.compare(this.value, other.value);
    }
}
```

#### **方法 2：使用 `Comparator<T>` 自定义排序**
```java
PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
    @Override
    public int compare(Cell c1, Cell c2) {
        return Integer.compare(c1.value, c2.value);
    }
});
```

#### **方法 3：使用 Lambda 表达式**
```java
PriorityQueue<Cell> pq = new PriorityQueue<>((c1, c2) -> Integer.compare(c1.value, c2.value));
```

### **如果 `E` 已实现 `Comparable` 但需要最大堆**
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
```
