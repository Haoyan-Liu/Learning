public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList();
    if (set == null) {
      return result;
    }
    char[] array = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    dfs(array, result, 0, sb);
    return result;
  }

  private void dfs(char[] array, List<String> result, int index, StringBuilder sb) {
    if (index == array.length) {
      result.add(sb.toString());
      return;
    }

    sb.append(array[index]);
    dfs(array, result, index + 1, sb);
    sb.deleteCharAt(sb.length() - 1);
    dfs(array, result, index + 1, sb);
  }
}
