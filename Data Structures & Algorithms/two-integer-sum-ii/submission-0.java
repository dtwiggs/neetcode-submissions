class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] + numbers[j] == target){
                return new int[] {i + 1, j + 1};
            } else if(numbers[i] + numbers[j] > target){
                j--;
                i--;
            }
        }
        return new int[] {-1, -1};
    }
}
