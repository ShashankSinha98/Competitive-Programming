def solve(n):
    global ans
    if n==1 or n==0:
        return str(n)

    a = solve(n//2)
    b = n%2
    ans = a+ str(b)+ a
    return ans






n,l,r = [int(i) for i in input().split()]
ans = ""
solve(n)
res=0
print(ans)
for i in range(l,r+1):
    if ans[i]=='1':
        res+=1

print(res)
