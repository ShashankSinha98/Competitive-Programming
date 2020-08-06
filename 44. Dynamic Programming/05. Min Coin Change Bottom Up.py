import sys
LIM = 10**3
dp = [0 for i in range(LIM)]
coins = [1,7,10]

def solve(val):
    global dp

    for i in range(1,val+1):
        temp = sys.maxsize
        for c in coins:
            if i-c>=0:
                temp = min(dp[i-c],temp)
        dp[i] = temp+1
        
    return dp[val]


n = int(input())
print(solve(n))