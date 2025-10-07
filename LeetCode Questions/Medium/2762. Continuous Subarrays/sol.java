import java.util.*;

public class sol {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {5,4,2,4};
        long result = s.continuousSubarrays(nums);
        System.out.println(result);
    }
}

class Solution {

    public long continuousSubarrays(int[] nums) {
        int right = 0, left = 0;
        int curMin, curMax;
        long windowLen = 0, total = 0;

        curMin = curMax = nums[right];

        for (right = 0; right < nums.length; right++) {
            curMin = Math.min(curMin, nums[right]);
            curMax = Math.max(curMax, nums[right]);

            if (curMax - curMin > 2) {
                windowLen = right - left;
                total += ((windowLen * (windowLen + 1)) / 2);

                left = right;
                curMin = curMax = nums[right];

                while (left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2) {
                    left--;
                    curMin = Math.min(curMin, nums[left]);
                    curMax = Math.max(curMax, nums[left]);
                }

                if (left < right) {
                    windowLen = right - left;
                    total -= ((windowLen * (windowLen + 1)) / 2);
                }
            }
        }

        windowLen = right - left;
        total += ((windowLen * (windowLen + 1)) / 2);

        return total;
    }
}
