/**
 * Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitArray(). (No loops needed.)


splitArray([2, 2]) → true
splitArray([2, 3]) → false
splitArray([5, 2, 3]) → true
 * */
public boolean splitArray(int[] nums) {
    // Calculate the sum of all elements in the array.
    int sum = 0;
    for (int num : nums) {
        sum += num;
    }
    
    // Check if the total sum is even and call the helper method.
    if (sum % 2 == 0) {
        return splitArrayHelper(nums, 0, 0, sum / 2);
    }
    
    // If the total sum is odd, it's impossible to split into two equal-sum groups.
    return false;
}

private boolean splitArrayHelper(int[] nums, int index, int group1Sum, int targetSum) {
    // Base case: If we've considered all elements, check if group1Sum equals the targetSum.
    if (index == nums.length) {
        return group1Sum == targetSum;
    }
    
    // Recursive step: Try including the current element in group 1 and group 2.
    // Recurse with the current element in group 1 and without it in group 2, and vice versa.
    return splitArrayHelper(nums, index + 1, group1Sum + nums[index], targetSum)
        || splitArrayHelper(nums, index + 1, group1Sum, targetSum);
}