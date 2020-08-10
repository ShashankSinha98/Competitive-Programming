# https://www.geeksforgeeks.org/min-cost-path-dp-6/

#n = 3
#arr = [[1,2,3],[4,8,2],[1,5,3]]



def solve(arr,dp):

    # row
    dp[0][0] = arr[0][0]

    for i in range(1,n):
        dp[i][0] = dp[i-1][0] + arr[i][0]

    # col
    for i in range(1,n):
        dp[0][i] = dp[0][i-1] + arr[0][i]

    for i in range(1,n):
        for j in range(1,n):
            dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + arr[i][j]

    return dp[n-1][n-1]




t = int(input())

while t!=0:
    t-=1
    
    n = int(input())
    arr = [[0]*n for i in range(n)]

    data = [int(i) for i in input().split()]
    k = 0
    for i in range(n):
        for j in range(n):
            arr[i][j] = data[k]
            k+=1
            
    dp = [[0]*n for i in range(n)]

    res = solve(arr,dp)
    print(res)

