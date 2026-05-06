class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int n = nums.length, num, x = 1, y = 1, tmp, max = -2147483648;
        System.out.println("This is x: " + x);
        System.out.println("This is y: " + y);
        for(int i = 0; i < n; i++){
            num = nums[i];
            if(num == 0){
                x = 1;
                y = 1;
                if(num > max){
                    max = num;
                }
                continue;
            }

            System.out.println("Pass number: " + (i + 1));
            System.out.println("Current index: " + num);
            
            x = x * num;
            System.out.println("Product 1: " + x);
            y = y * num;
            System.out.println("Product 2: " + y);

            tmp = x;

            x = Math.max(num, Math.max(x, y));
            System.out.println("Current max: " + x);
            y = Math.min(num, Math.min(tmp, y));
            System.out.println("Current min: " + y);
            if(x > max){
                max = x;
            }
            System.out.println("Overall max: " + max + "\n");
        }

        return max;
    }
}
