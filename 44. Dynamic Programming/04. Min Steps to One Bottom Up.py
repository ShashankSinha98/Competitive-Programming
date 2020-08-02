import sys
LIM=10**3
dp = [0 for i in range(LIM)]

def solve(num):
    global dp

    for i in range(2,num+1):
        x = sys.maxsize
        y = sys.maxsize

        if i%3==0:
            x = dp[i//3]
        if i%2==0:
            y = dp[i//2]
        z = dp[i-1]

        ans = min(x,y,z)
        dp[i] = ans + 1

    return dp[num]

num = int(input())
print(solve(num))

            