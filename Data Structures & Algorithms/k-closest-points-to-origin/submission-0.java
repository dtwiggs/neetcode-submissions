class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<double[]> heap = new PriorityQueue<>((a, b) -> 
        Double.compare(a[0], b[0])
        );

        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            double distance = Math.sqrt(x * x + y * y);

            heap.add(new double[] {distance, (double) x, (double) y});
        }

        for(int i = 0; i < k; i++){
            double[] tmp = heap.poll();
            res[i] = new int[] {(int) tmp[1], (int) tmp[2]};
        }

        return res;
    }
}
