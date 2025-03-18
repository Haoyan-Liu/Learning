// 凡人法

// recursion tree
//                                              “” [] {}
//                 /                               |                                 \                      
//            “a” [] {a}                       “b” [] {b}                        “c” [] {c}
//        /               \                 /               \                 /               \
//  “ab” [] {a,b}    “ac” [] {a,c}    “ba” [] {b,a}    “bc” [] {b,c}    “ca” [] {c,a}    “cb” [] {c,b}
//        /               \                 /               \                 /               \ 
// “abc” [] {a,b,c} “acb” [] {a,c,b} “bac” [] {b,a,c} “bca” [] {b,c,a} “cab” [] {c,a,b} “cba” [] {c,b,a}
// 最后一层返回
// “abc” [+"abc"] {a,b,c}   “acb” [+"acb"] {a,c,b}   “bac” [+"bac"] {b,a,c}   
// “bca” [+"bca"] {b,c,a}   “cab” [+"cab"] {c,a,b}   “cba” [+"cba"] {c,b,a}

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

// recursion tree
//                                               “abc” []
//                 /                                 |                                 \                      
//          “a|bc” s(0,0) []                  “b|ac” s(0,1) []                  “c|ba” s(0,2) []
//         /                \                /                \                /                \
//  “ab|c” s(1,1) [] “ac|b” s(1,2) [] “ba|c” s(1,1) [] “bc|a” s(1,2) [] “cb|a” s(1,1) [] “ca|b” s(1,2) []
// 如果终止条件是指针超界则还有一层s(2,2)
// 最后一层返回
// “ab|c” s(1,1) [+"abc"] “ac|b” s(1,2) [+"acb"] “ba|c” s(1,1) [+"bac"] 
// “bc|a” s(1,2) [+"bca"] “cb|a” s(1,1) [+"cba"] “ca|b” s(1,2) [+"cab"]

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
