LIM = 91

dp = [[0]*2 for i in range(LIM)]
dp[0][0] = dp[0][1] = 1 
for i in range(1,LIM):
    dp[i][0] = dp[i-1][0]+dp[i-1][1]
    dp[i][1] = dp[i-1][0]


def solve_opt(n):
    print(dp[n][0])


def solve(n,i,out):
    global ans
    if i==n:
        ans+=1
        return

    if len(out)==0 or out[-1]=="0":
        solve(n,i+1,out+"0")
        solve(n,i+1,out+"1")

    else:
        solve(n,i+1,out+"0")

t = int(input())
while t!=0:
    t-=1
    ans = 0
    n = int(input())
    solve_opt(n)
    #print(ans)