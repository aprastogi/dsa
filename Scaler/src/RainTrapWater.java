/* https://leetcode.com/problems/trapping-rain-water/ */
public class RainTrapWater {

    public static void main(String[] args) {
        int [] arr = {4,2,0,3,2,5};
        System.out.println("Max trap rain water is :: " + maxTrapRainWaterOptimized(arr));
        System.out.println("Max trap rain water is :: " + maxTrapRainWater(arr));
    }

    private static int maxTrapRainWaterOptimized(int[] arr) {
        int answer = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = arr.length - 1;
        while(left <= right){
            if(leftMax <= rightMax){
                leftMax = Math.max(leftMax, arr[left]);
                answer += leftMax - arr[left];
                left++;
            } else{
                rightMax = Math.max(rightMax, arr[right]);
                answer += rightMax - arr[right];
                right--;
            }
        }
        return answer;
    }

    public static int maxTrapRainWater(int [] arr){
        int answer = 0;
        int n = arr.length;
        int [] left = new int[n];
        int [] right = new int[n];
        for(int i=1;i<left.length;i++){
            left[i] = Math.max(left[i-1], arr[i-1]);
        }
        for(int i=right.length-2;i>=0;i--){
            right[i] = Math.max(right[i+1], arr[i+1]);
        }
        for(int i=0;i<arr.length;i++){
            int current = Math.min(left[i], right[i]) - arr[i];
            if(current > 0){
                answer +=  current;
            }
        }
        return answer;
    }
}
