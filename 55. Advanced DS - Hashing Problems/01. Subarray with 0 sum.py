class Soln:
    def solve(self,arr,n):
        
        if(0 in arr):
            return "YES"
        
        cumm = [0]*(n+1)
        for i in range(1,n+1):
            cumm[i] = cumm[i-1] + arr[i-1]
        
        myset = set()

        for i in cumm:
            if i in myset:
                return "YES"
            else:
                myset.add(i)
        
        return "NO"



t = int(input())

while t!=0:
    t-=1

    n = int(input())
    arr = [int(i) for i in input().split()]
    ans = Soln().solve(arr,n) 
    print(ans)
