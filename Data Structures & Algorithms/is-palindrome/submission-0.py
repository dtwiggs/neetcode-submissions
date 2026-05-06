class Solution:
    def isPalindrome(self, s: str) -> bool:
        cleanstring = ''
        for char in s:
            if char.isalnum():
                cleanstring += char.lower()
        return cleanstring == cleanstring[::-1]