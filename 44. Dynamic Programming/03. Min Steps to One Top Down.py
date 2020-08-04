
import sys

def solve(n: int):
    global dp

    if n==1:
        return 0

    if dp[n]!=0:
        return dp[n]

    x = y = z = sys.maxsize

    if n%3==0:
        x = dp[n//3] if dp[n//3]!=0 else solve(n//3)
    
    if n%2==0: 
        y = dp[n//2] if dp[n//2]!=0 else solve(n//2)

    z = dp[n-1] if dp[n-1]!=0 else solve(n-1)

    ans = min(x,y,z)+1
    dp[n] = ans
    return dp[n]

n = int(input())
dp = [0]*(n+1)
print(solve(n))
