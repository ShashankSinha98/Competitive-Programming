n, m = [int(i) for i in input().split()]
MOD = 10**9+7
arr = [[0]*m for i in range(n)]

for i in range(n):
    inp = input()
    for j in range(m):
        arr[i][j] = inp[j]





def solve(arr,n,m):

    dp = [[0]*(m+1) for i in range(n+1)]

    for i in range(1,n+1):
        if arr[i-1][0]=='#':
            break
        dp[i][1] = 1

    for i in range(1,m+1):
        if arr[0][i-1]=='#':
            break
        dp[1][i] = 1
    
    #print(dp)

    for i in range(2,n+1):
        for j in range(2,m+1):

            if arr[i-1][j-1]=='#':
                continue

            dp[i][j] = (dp[i-1][j] + dp[i][j-1])%MOD
    
    return dp[n][m]%MOD
    
print(solve(arr,n,m))