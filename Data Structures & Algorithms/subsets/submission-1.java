class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        subsetsRec(nums, 0, finalList, sub);
        return finalList;
    }

    private void subsetsRec(int[] nums, int index, List<List<Integer>> finalList, List<Integer> sub){
        if (index == nums.length) {
            finalList.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[index]);
        subsetsRec(nums, index + 1, finalList, sub);

        sub.remove(sub.size() - 1);
        subsetsRec(nums, index + 1, finalList, sub);
    }
}

