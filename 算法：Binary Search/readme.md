# 二分查找母题总结

## 第一类母题：经典问题（Classical Problem）

- 目标：查找目标值是否存在。
- 适用于 **查找特定元素**，如数组中的某个数。

### **代码模板**
```cpp
while (left ≤ right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
        return mid; // 找到目标值
    } else if (nums[mid] < target) {
        left = mid + 1; // 目标值在右半部分
    } else {
        right = mid - 1; // 目标值在左半部分
    }
}
return -1; // 未找到
```

### **二维查找（2D Binary Search）**
适用于 **有序二维矩阵**，如 Leetcode 240、74 题。

```cpp
int left = 0;
int right = matrix.length * matrix[0].length - 1;
while (left ≤ right) {
    int mid = left + (right - left) / 2;
    int row = mid / matrix[0].length;
    int col = mid % matrix[0].length;
    if (matrix[row][col] == target) {
        return true;
    } else if (matrix[row][col] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
return false;
```

---

## 第二类母题：查找第一个/最后一个出现的位置（First/Last Occurrence）

- 目标：查找目标值的**边界**（如数组中的第一个或最后一个匹配元素）。
- 适用于 **边界查找**，如找 **最左 / 最右** 位置。

### **代码模板（查找第一个出现的位置）**
```cpp
while (left < right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] >= target) {
        right = mid; // 收缩右边界，寻找最左匹配
    } else {
        left = mid + 1;
    }
}
return (nums[left] == target) ? left : -1;
```

### **代码模板（查找最后一个出现的位置）**
```cpp
while (left < right) {
    int mid = left + (right - left + 1) / 2;
    if (nums[mid] <= target) {
        left = mid; // 收缩左边界，寻找最右匹配
    } else {
        right = mid - 1;
    }
}
return (nums[left] == target) ? left : -1;
```
