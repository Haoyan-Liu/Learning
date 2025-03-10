# 第一类母题：经典问题（Classical Problem）

```cpp
while (left ≤ right);
```

## 二维查找

```cpp
left = 0;
right = matrix.length * matrix[0].length - 1;
mid = left + (right - left) / 2;
row = mid / matrix[0].length;
col = mid % matrix[0].length;
```

---

# 第二类母题：查找第一个/最后一个出现的位置（First/Last Occurrence）

```cpp
while (left < right - 1);
```
