def solve(n,k):

    dp = [0]*(n+1)
    dp[0] = 1

    for i in range(1,n+1):
        ans = 0
        for j in range(1,k+1):
            if i-j>=0:
                ans += dp[i-j]
        dp[i] = ans
    print(dp)
    return dp[n]


def optimized_solve(n,k):

    dp = [0]*(n+1)
    dp[0] = dp[1] = 1
    for i in range(2,k+1):
        dp[i] = 2*dp[i-1]
    
    for i in range(k+1,n+1):
        dp[i] = 2*dp[i-1] - dp[i-k-1]
    
    return dp[n]

print(optimized_solve(6,3))

