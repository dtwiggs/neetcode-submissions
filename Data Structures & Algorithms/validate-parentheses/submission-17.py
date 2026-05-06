class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        map = {"{":"}", "(":")", "[":"]"}

        for i in range(0, len(s), 1):
            curr = s[i]
            if curr in map:
                stack.append(curr)
            else:
                if not stack or map.get(stack.pop()) !=  curr:
                    return False
        if stack:
            return False
        return True