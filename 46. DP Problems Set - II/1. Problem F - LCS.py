MAX = 8
dp = [[-1]*MAX for i in range(MAX)]

def get_LCS_len(a,b,i,j):
    global dp

    if j>=len(a) or i>=len(b):
        return 0

    if dp[i][j] != -1:
        return dp[i][j]

    if a[j]==b[i]:
        dp[i][j] = get_LCS_len(a,b,i+1,j+1) + 1
    else:
        dp[i][j] = max(get_LCS_len(a,b,i+1,j),get_LCS_len(a,b,i,j+1))

    return dp[i][j]

def get_LCS(a,b,l):
    global dp
    i = j = 0
    res = ""

    while(l>0):
        if a[j]==b[i]:
            res += a[j]
            i+=1
            j+=1
            l-=1
        else:
            if (dp[i][j+1]>dp[i+1][j]):
                j+=1
            else:
                i+=1 
    
    return res


a = "AGGTAB"
b = "GXTXAYB"

l = get_LCS_len(a,b,0,0)
print(get_LCS(a,b,l))
print(dp)

