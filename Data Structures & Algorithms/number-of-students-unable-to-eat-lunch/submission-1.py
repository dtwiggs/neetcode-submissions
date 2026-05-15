class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        map = {0:0, 1:0}
        for student in students:
            map[student] += 1

        for sandwich in sandwiches:
            if map.get(sandwich) > 0:
                map[sandwich] -= 1
            else:
                break

        res = map[0] + map[1]
        return res