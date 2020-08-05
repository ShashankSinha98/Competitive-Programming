dp = [0]*100

def solve(n,k):

    if n == 0:
        return 1 # 1 way to stand on ground

    if dp[n] != 0:
        return dp[n]

    ans = 0
    for i in range(1,k+1):
        if n-i>=0:
            ans += dp[n-i] if dp[n-i] !=0 else solve(n-i,k)
    dp[n] = ans
    return dp[n]

print(solve(4,3))
