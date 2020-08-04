wines = [2,4,6,2,5]
dp = [[0]*len(wines) for i in range(len(wines))]


def solve(wines,i,j,y):
    global dp

    if i>j:
        return 0

    if dp[i][j]!=0:
        return dp[i][j]

    ans = max(wines[i]*y+solve(wines,i+1,j,y+1),wines[j]*y+solve(wines,i,j-1,y+1))
    dp[i][j] = ans
    return ans


print(solve(wines,0,len(wines)-1,1))


