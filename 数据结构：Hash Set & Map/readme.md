# HashSet 和 HashMap 主要方法

```java
Set<Integer> hashSet = new HashSet<>();
hashSet.add(E e); // 添加元素（如果不存在）
hashSet.remove(Object o); // 移除指定元素
hashSet.contains(Object o); // 是否包含指定元素
hashSet.size(); // 获取元素数量
hashSet.clear(); // 清空所有元素
hashSet.isEmpty(); // 是否为空
```

```java
Map<Integer, String> hashMap = new HashMap<>();
hashMap.put(K key, V value); // 添加或更新键值对
hashMap.get(Object key); // 获取键对应的值
hashMap.remove(Object key); // 移除键值对
hashMap.containsKey(Object key); // 是否包含指定键
hashMap.containsValue(Object value); // 是否包含指定值
hashMap.size(); // 获取键值对数量
hashMap.clear(); // 清空所有元素
hashMap.isEmpty(); // 是否为空
hashMap.keySet(); // 获取所有键
hashMap.values(); // 获取所有值
hashMap.entrySet(); // 获取所有键值对
```

---

# `==` vs `.equals()`

| 特性 | `==` (引用比较) | `.equals()` (值比较) |
| --- | --- | --- |
| 比较内容 | 内存地址 | 对象内容（值） |
| 适用于 | 基本数据类型 & 对象引用 | 主要用于对象值比较 |
| 默认行为 | 基本数据类型比较值，对象比较引用 | `Object` 类默认也是引用比较，需要重写 |
| 可重写？ | 否 | 是（用于自定义比较逻辑） |
| 示例 | `obj1 == obj2` → `false` (不同引用) | `obj1.equals(obj2)` → `true` (若重写) |

---

# `hashCode()` 方法

- `hashCode()` 默认使用对象的 **内存地址** 计算哈希值。
- 如果两个对象根据 `.equals()` 相等，则它们的 `hashCode()` **必须** 相同。
- `hashCode()` 主要用于 `HashMap`、`HashSet` 等集合中提高查找效率。

| 特性 | `hashCode()` | `equals()` |
| --- | --- | --- |
| 作用 | 生成唯一整数（哈希值） | 比较对象值是否相等 |
| 默认行为 | 使用对象的内存地址 | 也是按内存地址比较 |
| 何时重写？ | 当 `equals()` 被重写时 | 需要自定义对象比较逻辑时 |
| 在集合中的作用 | `HashMap`, `HashSet` 用于快速查找 | 保证对象唯一性 |

---

# Rehash（重新哈希）

| 概念 | 解释 |
| --- | --- |
| **什么是 Rehashing?** | 当元素超过 `capacity * load factor` 时，哈希表会扩容并重新计算哈希值。 |
| **什么时候发生?** | 当负载因子超限时（默认 0.75）。 |
| **如何执行?** | 扩容为原来的 2 倍，并重新分配所有元素。 |
| **Rehashing 成本?** | O(n)，因为所有元素都需要重新计算哈希值。 |
| **如何减少 Rehashing?** | 预设较大的初始容量、优化 `hashCode()` 方法。 |

---

# 迭代器（Iterator）

```java
Iterator<String> iterator = set.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```
