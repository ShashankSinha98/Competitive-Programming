class Solution:

    def count_pairs(self,arr : [])->int:
        
        mySet = set()
        for i in arr:
            mySet.add(i[::-1])
        
        print(mySet)

        cnt = 0
        for i in arr:
            if(len(i)==1):
                continue

            for j in range(1,len(i)+1):
                if i[:j] in mySet and (j+1==len(i) or self.isPallindrome(i[j+1:])):
                    print(i[:j])
                    cnt+=1

        for i in arr:
            if(len(i)==1):
                continue
            
            for j in range(len(i)-1,-1,-1):
                if i[j:len(i)] in mySet and ( self.isPallindrome(i[0:j])):
                    cnt+=1
        return cnt




    def isPallindrome(self,s : str) -> bool:

        if len(s)==0:
            return True
        
        left = 0
        right = len(s)-1

        while left<right:

            if s[left] != s[right]:
                return False
            
            left+=1
            right-=1
        
        return True

arr = ["abcd","dcba","lls","s","sssll"]

print(Solution().count_pairs(arr))
