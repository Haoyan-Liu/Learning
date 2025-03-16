public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subResult = new ArrayList<>();
    int coinInConsiderIndex = 0;
    combinations(target, coins, coinInConsiderIndex, result, subResult);
    return result;
  }

  private void combinations(int target, int[] coins, int coinInConsiderIndex, List<List<Integer>> result, List<Integer> subResult) {
    if (target == 0) {
      if (subResult.size() == coins.length) {
        while (coins.length - subResult.size() > 0) {
          subResult.add(0);
        }
      result.add(new ArrayList<>(subResult));  // very important
      return;
      }
    }
    // If we have considered all coins, stop
    if (coinInConsiderIndex == coins.length) {
      return;
    }
    
    int coinValue = coins[coinInConsiderIndex];
    int maxCount = target / coins[coinInConsiderIndex];

    for (int i = 0; i <= maxCount; i++) {
      // put i coins in
      subResult.add(i);
      // recursion
      combinations(target - i * coinValue, coins, coinInConsiderIndex + 1, result, subResult);
      // get i coins out
      subResult.remove(subResult.size() - 1);
    }
  }
}
