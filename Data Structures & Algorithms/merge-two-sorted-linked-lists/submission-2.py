# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 == None:
            return list2
        if list2 == None:
            return list1
        
        cur = None
        head = None # we only use head to ret result
        if list1.val < list2.val:
            cur = list1
            head = list1
            list1 = list1.next
        else:
            cur = list2
            head = list2
            list2 = list2.next

        while list1 != None and list2 != None:
            if list1.val < list2.val:
                cur.next = list1
                cur = cur.next
                list1 = list1.next
            else:
                cur.next = list2
                cur = cur.next
                list2 = list2.next

        # at the end, point it to the leftovers
        if not list1:
            cur.next = list2
        else:
            cur.next = list1
        
        return head