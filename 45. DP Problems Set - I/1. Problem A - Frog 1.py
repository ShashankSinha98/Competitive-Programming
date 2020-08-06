n = int(input())
arr = [int(i) for i in input().split()]

def solve(arr,n):

    dp = [0]*n

    for i in range(1,n):

        if i-2>=0:
            dp[i] = min(abs(arr[i]-arr[i-1])+dp[i-1],abs(arr[i]-arr[i-2])+dp[i-2])
        else:
            dp[i] = abs(arr[i]-arr[i-1])
    #print(dp)
    return dp[-1]

print(solve(arr,n))