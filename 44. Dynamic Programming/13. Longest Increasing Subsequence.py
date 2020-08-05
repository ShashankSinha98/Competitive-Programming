def solve(arr,n):

    dp = [1]*n

    for i in range(1,n):
        best = 0
        for j in range(i):
            if arr[j]<arr[i]:
                best = max(dp[j],best)
        dp[i] = best+1
    print(dp)
    return max(dp)

arr = [int(i) for i in input().split()]
print(solve(arr,len(arr)))