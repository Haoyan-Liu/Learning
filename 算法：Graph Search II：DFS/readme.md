# 深度优先搜索（DFS）结构
## Recursion Based Algorithm - 吃吐守恒

### **什么时候想到 DFS？**
1. **当题目问你所有可能解的时候**（All Possible XXX）
2. **当我们要解决存在性的问题**

---

### **Combination vs Permutation**

|  | **排列（Permutation）** | **组合（Combination）** |
| --- | --- | --- |
| **定义** | 选取且**顺序不同视为不同** | 选取且**顺序不同视为相同** |
| **公式** | \( P(n, r) = \frac{n!}{(n-r)!} \) | \( C(n, r) = \frac{n!}{r!(n-r)!} \) |
| **示例** | 选 2 人站队，AB 和 BA **不同** | 选 2 人做小组，AB 和 BA **相同** |
| **计算复杂度** | 更大 | 更小 |
