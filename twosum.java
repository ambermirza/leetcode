public class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* brute force
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                if (nums[b] == target - nums[a]) {
                    return new int[] { a, b };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");  */
        
        /* more efficient answer */
        int length = nums.length;
        Map<Integer, Integer> ans = new HashMap<>();
        
        for (int a = 0; a < length; a++) {
            int b = target - nums[a]; //b is what needs to be added to get the sume
            if (ans.containsKey(b)) { //check to see if its in the hash
                return new int[] { ans.get(b), a };
            }
            ans.put(nums[a], a);
        }
        throw new IllegalArgumentException("No two sum solution");        
    }
}
