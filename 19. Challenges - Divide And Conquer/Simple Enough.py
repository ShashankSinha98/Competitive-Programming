def cal_range(n):

    res = 0
    while n!=0:
        res+=1
        n = n>>1
    return ((2**res)-1)


def solve(n,st,end,l,r):
    global ans

    if(st>end):
        return

    if (st<l and end<l) or (st>r and end>r):
        return
    
    if (st==end and l<=st<=r):
        ans+=(n % 2)
        return
    
    mid = (st+end)//2

    if (l<=mid<=r):
        ans+=(n % 2)
    
    solve(n//2,st,mid-1,l,r)
    solve(n//2,mid+1,end,l,r)

n,l,r = [int(i) for i in input().split()]
ans = 0
solve(n,1,cal_range(n),l,r)
print(ans)