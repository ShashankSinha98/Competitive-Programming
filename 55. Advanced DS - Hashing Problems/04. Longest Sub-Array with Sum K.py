class Soln:
    def solve(self,arr,n,k):
        
        maxLen = 0
        
        cumm = [0]*(n+1)
        mydict = {}
        mydict[0] = 0

        for i in range(1,n+1):
            cumm[i] = cumm[i-1] + arr[i-1]
            mydict[cumm[i]] = i

        print(mydict)

        for i in range(0,n+1):
            key = cumm[i]+k

            if key in mydict:
                j = mydict.get(key)
                maxLen = max(maxLen,j-i)
        
        return maxLen
        




t = int(input())

while t!=0:
    t-=1

    n,k = [int(i) for i in input().split()]
    arr = [int(i) for i in input().split()]
    ans = Soln().solve(arr,n,k) 
    
    print(ans)
