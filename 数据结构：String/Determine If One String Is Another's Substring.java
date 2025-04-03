public class Solution {
  public int strstr(String large, String small) {
    // Write your solution here
    if (large == null || small == null || large.length() < small.length()) {
      return -1;
    }
    if (small.length() == 0) {return 0;}
    // i window的起始位置
    // j  window内的遍历指针
    // large = 6
    // small = 2
    int i = 0;
    int j = 0;
    for (i = 0; i <= large.length() - small.length(); i++) {
      for (j = 0; j < small.length(); j++) {
        if (large.charAt(i+j) == small.charAt(j)) {
          if (j == small.length() - 1) {
            return i;
          } 
          else {continue;}
        }
        else {break;}
      }
    }
    return -1;
  }
}
