class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        hashmap = {}
        for letter in s:
            if letter in hashmap:
                hashmap[letter] +=1
            else:
                hashmap[letter] = 1
        
        for letter in t:
            if letter not in hashmap:
                return False
            else:
                if hashmap[letter] == 1:
                    del hashmap[letter]
                else:
                    hashmap[letter] -=1 
        if hashmap == {}:
            return True
        else:
            return False