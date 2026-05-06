class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        size = len(arr)
        res = [0] * size
        max_num = -1

        for i in range(size - 1, -1, -1):
            res[i] = max_num
            max_num = max(arr[i], max_num)
            
        return res
        