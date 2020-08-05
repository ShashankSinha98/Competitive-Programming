def max_profit(cost):
    n = len(cost)
    dp = [0] * (n+1)

    for l in range(1,n+1):
        best = 0
        for cut in range(1,l+1):
            best = max(best,cost[cut-1]+dp[l-cut])
        dp[l] = best
    
    return dp[n]

cost = [2,3,2,5]
print(max_profit(cost))