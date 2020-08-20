import sys
LIM = 10**4

def solve(val):
    global dp, coins

    for i in range(1,val+1):
        temp = sys.maxsize
        for c in coins:
            if i-c>=0:
                temp = min(dp[i-c],temp)
        dp[i] = temp+1
        
    print(dp)
    return dp[val]


n = int(input())
coins = [int(i) for i in input().split()]
dp = [0 for i in range(n+1)]
print(solve(n))