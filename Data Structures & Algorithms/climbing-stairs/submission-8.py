class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 0 or n == 1 or n == 2 or n == 3:
            return n
        
        i = 4
        res = [3, 2, 1]
        while i <= n:
            res[2] = res[1]
            res[1] = res[0]
            res[0] = res[1] + res[2]
            i += 1

        return res[0]