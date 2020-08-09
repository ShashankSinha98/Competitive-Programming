a = "AGGTAB"
b = "GXTXAYB"
op = ""
MAX = 3000
dp = [[-1]*MAX for i in range(MAX)]

def solve_topdown(a,b,i,j):

    if j>=len(a) or i>=len(b):
        return 0

    if dp[i][j] != -1:
        return dp[i][j]

    ans = -1
    if a[j] == b[i]:
        ans = 1+solve_topdown(a,b,i+1,j+1)
    else:
        ans = max(solve_topdown(a,b,i+1,j),solve_topdown(a,b,i,j+1))
    
    dp[i][j] = ans

    return ans




def solve(a,b):
    global op

    la = len(a)
    lb = len(b)

    dp = [[0]*(la+1) for i in range(lb+1)]

    for i in range(1,lb+1):
        for j in range(1,la+1):
            if a[j-1]==b[i-1]:
                op += a[j-1]
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                dp[i][j] = max(dp[i-1][j],dp[i][j-1])
    
    return dp[lb][la],dp

def get_LCS(a,b,l,dp):
    
    i = len(b)
    j = len(a)
    res = ""

    while(l>0):
        if a[j-1]==b[i-1]:
            res = a[j-1] + res
            i-=1
            j-=1
            l-=1
        else:
            if (dp[i][j-1]>dp[i-1][j]):
                j-=1
            else:
                i-=1 
    
    return res

l,dp = solve(a,b)
#print(l,dp)
print(get_LCS(a,b,l,dp))