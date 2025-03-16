public class Solution {
  public List<String> validParentheses(int n) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int leftNeed = n;
    int rightNeed = n;
    validParentheses(result, sb, leftNeed, rightNeed);
    return result;
  }

  private void validParentheses(List<String> result, StringBuilder sb, int leftNeed, int rightNeed) {
    if (rightNeed == 0) {
      result.add(sb.toString());
      return;
    }
    if (leftNeed > 0) {
      sb.append('(');
      validParentheses(result, sb, leftNeed-1, rightNeed);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (rightNeed > leftNeed) {
      sb.append(')');
      validParentheses(result, sb, leftNeed, rightNeed-1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
