import sys
LIM = 10**3
dp = [0 for i in range(LIM)]
coins = [2,1]

def solve(val):
    global dp

    temp = sys.maxsize
    for i in range(1,val+1):
        for c in coins:
            if i-c>=0:
                temp = min(dp[i-c],temp)
        dp[i] = temp+1
        temp = sys.maxsize
    return dp[val]


n = int(input())
print(solve(n))