import sys
LIM=100
dp = [0 for i in range(LIM)]

def solve(num):
    global dp

    if num==1:
        return 0

    if dp[num]!=0:
        return dp[num]
    
    x = solve(num//3) if num%3==0 else sys.maxsize
    y = solve(num//2) if num%2==0 else sys.maxsize
    z = solve(num-1)

    dp[num] = min(x,y,z) + 1
    return dp[num]



num = int(input())
print(solve(num))
#print(dp)

