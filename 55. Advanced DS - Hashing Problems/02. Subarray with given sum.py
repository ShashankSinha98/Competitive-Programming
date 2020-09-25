class Soln:
    def solve(self,arr,n,k):
        
        if(k in arr):
            indx = str(arr.index(k)+1)
            return indx,indx
        
        cumm = [0]*(n+1)
        mydict = {}
        mydict[0] = 0

        for i in range(1,n+1):
            cumm[i] = cumm[i-1] + arr[i-1]
            mydict[cumm[i]] = i

        for i in range(0,n+1):
            key = cumm[i]+k

            if key in mydict:
                j = mydict.get(key)
                return i+1,j
        
        return -1,-1
        




t = int(input())

while t!=0:
    t-=1

    n,k = [int(i) for i in input().split()]
    arr = [int(i) for i in input().split()]
    i,j = Soln().solve(arr,n,k) 
    if(i!=-1):
        print("{} {}".format(i,j))
    else:
        print("-1")
