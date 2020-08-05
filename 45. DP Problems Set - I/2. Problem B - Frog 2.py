import sys
n,k = [int(i) for i in input().split()]
arr = [int(i) for i in input().split()]

def solve(arr,n,k):

    dp = [0]*n

    for i in range(1,n):
        best = sys.maxsize
        for j in range(i-1,i-k-1,-1):
            if j<0:
                break
            else:
                best = min(abs(arr[i]-arr[j])+dp[j],best) 

        dp[i] = best

    return dp[n-1]


print(solve(arr,n,k))
