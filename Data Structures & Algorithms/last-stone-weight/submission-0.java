class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++){
            heap.add(stones[i]);
        }

        while(heap.size() > 1){
            int rock = heap.poll();
            int stone = heap.poll();
            if(rock < stone){
                stone = stone - rock;
                heap.add(stone);
            } else if(rock > stone){
                rock = rock - stone;
                heap.add(rock);
            }
        }

        if(heap.isEmpty()){
            return 0;
        } else{
            return heap.poll();
        }
    }
}