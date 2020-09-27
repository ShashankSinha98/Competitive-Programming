class Solution:
    
    mySet = set()
    visited = set()

    def longestConsecutive(self,nums) -> int:

        for i in nums:
            self.mySet.add(i)

        maxCnt = 0
        for i in nums:
            if i not in self.visited:
                maxCnt = max(maxCnt,self.helper(i))
        
        return maxCnt



    def helper(self, i):

        if i not in self.mySet:
            return 0
        
        if i in self.visited:
            return 0
        
        self.visited.add(i)
        
        return self.helper(i+1)+self.helper(i-1)+1



arr = [1, 9, 3, 10, 4, 20, 2]
ans = Solution().longestConsecutive(arr)
print(ans)