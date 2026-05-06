class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
         myset = set()
         for num in nums:
            if num in myset:
                return True
            else:
                myset.update([num])
        
         return False