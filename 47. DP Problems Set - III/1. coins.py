n = int(input())
arr = [float(i) for i in input().split()]


def solve(arr,n,x):
    global dp
    if x==0:
        return 1
    
    if n==0:
        return 0

    if dp[n][x]> -0.9:
        return dp[n][x]

    dp[n][x] = round(arr[n-1]*solve(arr,n-1,x-1),3) + round((1-arr[n-1])*solve(arr,n-1,x),3)
    
    return round(dp[n][x],3)

x = (n+1)//2
dp = [[-1]*(x+1) for i in range(n+1)]
print(solve(arr,n,x))
print(dp)

    