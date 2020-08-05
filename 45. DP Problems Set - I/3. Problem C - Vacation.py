n = int(input())
inp_arr = [[0]*3 for i in range(n)]
for i in range(n):
    inp = [int(j) for j in input().split()]
    for j in range(3):
        inp_arr[i][j] = inp[j]


def solve(arr,n):

    dp = [[0]*3 for i in range(n)] 

    dp[0][0] = inp_arr[0][0]
    dp[0][1] = inp_arr[0][1]
    dp[0][2] = inp_arr[0][2]

    for i in range(1,n):
        dp[i][0] = arr[i][0] + max(dp[i-1][1],dp[i-1][2])
        dp[i][1] = arr[i][1] + max(dp[i-1][0],dp[i-1][2])
        dp[i][2] = arr[i][2] + max(dp[i-1][0],dp[i-1][1])

    return max(dp[n-1][0],dp[n-1][1],dp[n-1][2])

print(solve(inp_arr,n)) 
