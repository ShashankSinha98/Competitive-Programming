class Solution:
    
    mySet = set()
    visited = set()

    def longestConsecutive(self,nums) -> int:
        self.mySet = set()
        self.visited = set()
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


t = int(input())
while t!=0:
    t-=1

    n = int(input())
    arr = [int(i) for i in input().split()]

    ans = Solution().longestConsecutive(arr)
    print(ans)