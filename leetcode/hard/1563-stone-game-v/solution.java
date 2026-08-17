class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[][] dp = new int[n][n];
        int[] prefix = new int[n+1];

        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i] + stoneValue[i];
            dp[i][i] = 0;
        }

        for(int left=n-1;left>=0;left--){
            for(int right=0;right<n;right++){
                int totalSum = prefix[right+1]-prefix[left];

                int maxScore = 0;

                for(int i=left;i<=right-1;i++){
                    int leftSum = prefix[i+1]-prefix[left];
                    int rightSum = totalSum-leftSum;
                    
                    if(leftSum == rightSum){
                        int l = leftSum + dp[i+1][right];
                        int r = rightSum + dp[left][i];
                        maxScore = Math.max(maxScore, Math.max(l, r));
                    }
                    else if(leftSum < rightSum){
                        maxScore = Math.max(maxScore ,leftSum+dp[left][i]);
                    }
                    else{
                        maxScore = Math.max(maxScore, rightSum + dp[i+1][right]);
                    }
                }
                
                dp[left][right] = maxScore;
            }
        }

        return dp[0][n-1];
    }

}