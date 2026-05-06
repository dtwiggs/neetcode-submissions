class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();

        if(nums == null){
        } else{
            finalList.add(new ArrayList<>());
            for (int i = 0; i < nums.length; i++) {
                int finalListSize = finalList.size();
                for (int j = 0; j < finalListSize; j++) {
                    List<Integer> newSubset = new ArrayList<>(finalList.get(j));
                    newSubset.add(nums[i]);
                    finalList.add(newSubset);
                }
            }
        }

        return finalList;
    }
}