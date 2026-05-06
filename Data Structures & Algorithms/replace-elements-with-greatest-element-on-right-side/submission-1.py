class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        size = len(arr)
        res = [0] * size
        res[size - 1] = -1
        max_num = arr[size - 1]

        for i in range(size - 1, 0, -1):
            max_num = max(arr[i], max_num)
            res[i - 1] = max_num
            
        return res
        