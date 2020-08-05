import sys
n,w = [int(i) for i in input().split()]
inp_arr = [[0]*2 for i in range(n)]

for i in range(n):
    inp = [int(j) for j in input().split()]
    for j in range(2):
        inp_arr[i][j] = inp[j]

def solve_recc(arr,n,w):

    if w<=0 or n<=0:
        return 0

    if arr[n-1][0]>w:
        return solve_recc(arr,n-1,w)
    


    return max(solve_recc(arr,n-1,w), arr[n-1][1]+solve_recc(arr,n-1,w-arr[n-1][0]))

   
def solve_dp(arr,n,w):

    dp = [[0]*(w+1) for i in range(n+1)]

    for i in range(1,n+1):
        for wj in range(1,w+1):

            if arr[i-1][0]<=wj:
                dp[i][wj] = max(arr[i-1][1]+dp[i-1][wj-arr[i-1][0]],dp[i-1][wj])
            else:
                dp[i][wj] = dp[i-1][wj]
            
    print(dp)
    return dp[n][w]

print(solve_dp(inp_arr,n,w))



