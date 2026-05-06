class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            return true;
        }
        return canFinishRec(numCourses, prerequisites, 0);
    }

    private boolean canFinishRec(int total, int[][] preReq, int curr) {
        boolean res = true;
        int upper = preReq[curr][0];
        int lower = preReq[curr][1];
        map.put(upper, lower);

        if(curr + 1 < preReq.length){
            res = canFinishRec(total, preReq, curr + 1);
        }

        if(res == false){
            return false;
        }

        for(int i = 0; i < map.size(); i++){
            if(map.containsKey(lower)){
                if(map.get(lower) == upper){
                    return false;
                }
                lower = map.get(lower);
            } else{
                return true;
            }

            if(i == map.size() - 1 && map.containsKey(lower)){
                return false;
            }
        }
        return res;
    }
}