class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0){
            return "";
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            str.append(strs.get(i));
            str.append("KEY");
        }

        return str.toString();
    }

    public List<String> decode(String str) {
        int j = 0;
        List<String> strs = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'K'){
                if(str.substring(i, i + 3).equals("KEY")){
                    strs.add(str.substring(j, i));
                    i += 2;
                    j = i + 1;
                }
            }
        }

        return strs;
    }
}
