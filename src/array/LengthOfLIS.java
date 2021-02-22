package array;

/**
 * @author yeweixiong
 * @since 2021/2/5 15:23
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/submissions/
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        print(dp);

        return max;


    }

    private void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
//        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] arr = {4, 10, 4, 3, 8, 9};
        System.out.println(lengthOfLIS.lengthOfLIS(arr));
    }
}
