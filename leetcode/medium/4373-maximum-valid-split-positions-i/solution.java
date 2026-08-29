class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        // Precompute prefix and suffix GCD arrays
        int[] prefGcd = new int[n];
        int[] suffGcd = new int[n];

        prefGcd[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefGcd[i] = computeGcd(prefGcd[i - 1], nums[i]);
        }

        suffGcd[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffGcd[i] = computeGcd(nums[i], suffGcd[i + 1]);
        }

        int fullGcd = prefGcd[n - 1];

        // Base Case: Count valid splits without removing any element
        int maxSplits = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prefGcd[i] == suffGcd[i + 1]) {
                maxSplits++;
            }
        }

        // Case: Test removing a single element at index 'removedIdx'
        for (int removedIdx = 0; removedIdx < n; removedIdx++) {
            int gcdAfterRemoval = 0;
            if (removedIdx > 0) {
                gcdAfterRemoval = computeGcd(gcdAfterRemoval, prefGcd[removedIdx - 1]);
            }
            if (removedIdx + 1 < n) {
                gcdAfterRemoval = computeGcd(gcdAfterRemoval, suffGcd[removedIdx + 1]);
            }

            // Skip if removing this element does not change overall GCD
            if (gcdAfterRemoval == fullGcd) {
                continue;
            }

            int validSplitsWithRemoval = 0;

            // Evaluate valid split indices in the reduced array (length n - 1)
            for (int split = 0; split < n - 1; split++) {
                if (split == removedIdx) {
                    continue; // Skip the redundant split position created by deletion
                }

                int leftGcd = getPrefixGcd(split, removedIdx, prefGcd, nums);
                int rightGcd = getSuffixGcd(split + 1, removedIdx, suffGcd, nums);

                if (leftGcd == rightGcd) {
                    validSplitsWithRemoval++;
                }
            }

            maxSplits = Math.max(maxSplits, validSplitsWithRemoval);
        }

        return maxSplits;
    }

    private int getPrefixGcd(int boundary, int skipIdx, int[] prefGcd, int[] nums) {
        if (boundary < skipIdx) {
            return prefGcd[boundary];
        }
        int res = (skipIdx > 0) ? prefGcd[skipIdx - 1] : 0;
        for (int i = skipIdx + 1; i <= boundary; i++) {
            res = computeGcd(res, nums[i]);
        }
        return res;
    }

    private int getSuffixGcd(int boundary, int skipIdx, int[] suffGcd, int[] nums) {
        if (boundary > skipIdx) {
            return suffGcd[boundary];
        }
        int res = (skipIdx + 1 < nums.length) ? suffGcd[skipIdx + 1] : 0;
        for (int i = skipIdx - 1; i >= boundary; i--) {
            res = computeGcd(res, nums[i]);
        }
        return res;
    }

    private int computeGcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return Math.abs(a);
    }
}