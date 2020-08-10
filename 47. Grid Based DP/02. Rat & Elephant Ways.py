n = int(input())
k = int(input())

dp = [[0]*n for i in range(n)]
dp[0][0]=1

# row
for i in range(1,n):
    for j in range(i-1,i-k-1,-1):
        if j<0:
            break
        dp[i][0] = dp[i][0]+dp[j][0]

# col
for i in range(1,n):
    for j in range(i-1,i-k-1,-1):
        if j<0:
            break
        dp[0][i] = dp[0][i]+dp[0][j]

for i in range(1,n):
    for j in range(1,n):
        res = 0
        for t in range(i-1,i-k-1,-1):
            if t<0:
                break
            res+= dp[t][j]
        
        for t in range(j-1,j-k-1,-1):
            if t<0:
                break
            res+= dp[i][t]
        
        dp[i][j] = res


print(dp)
print(dp[n-1][n-1])


