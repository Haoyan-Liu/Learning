# 递归步骤

1. **Recursion function能做什么：**
    - function signature：input是什么，output是什么，
    - function能完成什么事儿
2. **Base case：**
    - 最小号的子问题
    - 你什么都不用做就能直接return的子问题
3. **Subproblem：**
    - input size比原问题小一号的问题
    - 这个问题本身要做的事和原问题是完全一致的
4. **Recursion rule：**
    - 大一号的问题和小一号的问题的逻辑关系，假设我有了小一号的问题的结果后，当前层我做点什么事就可以得到原问题的解
