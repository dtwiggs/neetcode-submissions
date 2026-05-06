class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        combSumRec(nums, target, 0, 0, new ArrayList<>(), res);

        return res;
    }

    private void combSumRec(int[] a, int target, int i, int curr, List<Integer> tmp, List<List<Integer>> res){
        if(curr == target){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int j = i; j < a.length; j++){
            if(curr + a[j] > target){
                return;
            }

            tmp.add(a[j]);
            combSumRec(a, target, j, curr + a[j], tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}