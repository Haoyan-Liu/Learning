# 第一类母题：Classical Problem 找到就行

```cpp
while (left ≤ right);
```

## 2D

```cpp
left = 0;
right = matrix.length * matrix[0].length - 1;
mid = left + (right - left) / 2;
row = mid / matrix[0].length;
col = mid % matrix[0].length;
```

---

# 第二类母题：First/Last Occurrence

```cpp
while (left < right - 1);
