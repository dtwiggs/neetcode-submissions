class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            int[] tmp = new int[26];
            for(int j = 0; j < strs[i].length(); j++){
                tmp[strs[i].charAt(j) - 'a']++;
            }
            String key = Arrays.toString(tmp);

            if(map.isEmpty() || !map.containsKey(key)){
                map.put(key, new ArrayList<>(List.of(i)));
            } else{
                map.get(key).add(i);
            }
        }

        for(Map.Entry<String, List<Integer>> entry : map.entrySet()){
            List<Integer> curr = entry.getValue();
            List<String> tmp = new ArrayList<>();
            for(int i = 0; i < curr.size(); i++){
                tmp.add(strs[curr.get(i)]);
            }
            res.add(tmp);
        }
        
        return res;
    }
}