// 凡人法
// public class Solution {
//   public List<String> permutations(String input) {
//     // Write your solution here
//     Set<Character> visited = new HashSet<>();
//     List<String> result = new ArrayList<>();
//     StringBuilder sb = new StringBuilder();

//     if (input.length() == 0) {
//       result.add("");
//       return result;
//     }

//     permutations(input, visited, result, sb);
//     return result;
//   }

//   private List<String> permutations(String input, Set<Character> visited, List<String> result, StringBuilder sb) {
//     if (visited.size() == input.length()) { // 所有char已经被访问过
//       result.add(sb.toString()); // 将sb加入结果集并返回
//       return result;
//     }
//     for (int index = 0; index < input.length(); index++) {
//       char curChar = input.charAt(index);
//       if (!visited.contains(curChar)) { // 只有在当前char不在已访问列表时才继续进行，否则换char
//         sb.append(curChar); // 吃
//         visited.add(curChar); // 吃
//         permutations(input, visited, result, sb); // 下一层
//         sb.deleteCharAt(sb.length() - 1); // 吐
//         visited.remove(curChar); // 吐
//       }
//     }
//     return result;
//   }
// }

// 仙法
public class Solution {
  public List<String> permutations(String input) {
    // Write your solution here
    char[] chars = input.toCharArray();
    int curIndexNeedSwap = 0;
    List<String> result = new ArrayList<>();
    if (input.length() == 0) {
      result.add("");
      return result;
    }
    permutations(chars, curIndexNeedSwap, result);
    return result;
  }

  private List<String> permutations(char[] chars, int curIndexNeedSwap, List<String> result) {
    if (curIndexNeedSwap == chars.length - 1) {
      result.add(new String(chars));
      return result;
    }
    for (int i = curIndexNeedSwap; i < chars.length; i++) { // i从curIndexNeedSwap开始就不会影响前面已经定下来的index
      swap(chars, i, curIndexNeedSwap); // 吃
      permutations(chars, curIndexNeedSwap + 1, result); // 去下一个需要swap的index 
      swap(chars, i, curIndexNeedSwap); // 吐
    }
    return result;
  }

  private void swap(char[] chars, int i, int j) {
    char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }
}
