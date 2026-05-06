class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        String key;

        for(int i = 0; i < strs.length; i++){
            int[] tmp = new int[26];
            for(int j = 0; j < strs[i].length(); j++){
                tmp[strs[i].charAt(j) - 'a']++;
            }
            key = Arrays.toString(tmp);

            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            } else{
                map.put(key, new ArrayList<>());
                map.get(key).add(strs[i]);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> val = entry.getValue();
            res.add(val);
        }

        return res;
    }
}
