class Solution {
    public int trap(int[] height) {
        int n = height.length;
        // calc left most boundary - aux array / helper array
        int leftMost[] = new int[n];
        leftMost[0] = height[0];
        for(int i = 1 ; i < n ; i++){
            leftMost[i] = Math.max(height[i], leftMost[i-1]);
        }
        // calc right most boundary - aux array / helper array
        int rightMost[] = new int[n];
        rightMost[n-1] = height[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            rightMost[i] = Math.max(height[i] , rightMost[i+1]);
        }

        // water level  = min(leftMoat, rightMost)
        // trapped Water = water level - water level
        int trappedWater = 0;
        for(int i = 0 ; i < n ; i++){
            int waterLevel = Math.min(leftMost[i], rightMost[i]);
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;
    }
}