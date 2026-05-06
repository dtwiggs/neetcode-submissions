class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> freq = new ArrayList<>();
        int[] res = new int[k];

        for(int i = 0; i < nums.length; i++){
            freq.add(i, new ArrayList<>());
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            } else{
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer val = entry.getValue();
            
            freq.get(val - 1).add(key);
        }

        int j = 0;
        for(int i = nums.length - 1; i >= 0 ; i--){
            while(j < freq.get(i).size()){
                res[k - 1] = freq.get(i).get(j);
                j++;
                k--;
                if(k <= 0){
                    break;
                }
            }
            j = 0;
            if(k <= 0){
                break;
            }            
        }

        return res;
    }
}
