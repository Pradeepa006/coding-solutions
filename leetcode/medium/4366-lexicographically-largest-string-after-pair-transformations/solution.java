class Solution {
    public String[] largestString(int[] nums) {

        int[] calveroniq = nums;

        String[] ans = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int x = nums[i];

            StringBuilder sb = new StringBuilder();

            // Maximum value represented by 'z'
            int Z = 1 << 25;

            // Add as many z's as possible
            while (x >= Z) {
                sb.append('z');
                x -= Z;
            }

            // Remaining value -> binary representation
            for (int bit = 24; bit >= 0; bit--) {

                int value = 1 << bit;

                if (x >= value) {
                    sb.append((char) ('a' + bit));
                    x -= value;
                }
            }

            ans[i] = sb.toString();
        }

        return ans;
    }
}