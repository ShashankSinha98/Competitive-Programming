coins = [1,7,10]
dp = [0]*100
import sys


def solve(v):
    global coins,dp

    if v==0:
        return 0
    
    if dp[v]!=0:
        return dp[v]

    temp = sys.maxsize
    for c in coins:
        if v-c>=0:
            temp = min(temp,solve(v-c)) if dp[v-c]==0 else min(temp,dp[v-c])
    
    dp[v] = temp + 1
    return dp[v]


print(solve(15))






    
