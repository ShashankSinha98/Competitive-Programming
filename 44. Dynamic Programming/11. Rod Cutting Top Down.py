cost = [1,5,8,9,10,17,17,20]
dp = [0]*100

def max_profit(n,cost):
    global dp

    if n == 0:
        return 0

    if dp[n]!=0:
        return dp[n]

    best_profit = 0
    for i in range(1,n+1):
        profit = cost[i-1]+max_profit(n-i,cost)
        best_profit = max(best_profit,profit)

    dp[n] = best_profit

    return best_profit

print(max_profit(8,cost))



    