
wines = [2,4,6,2,5]

n = len(wines)
dp = [[0]*n for i in range(n)]

for i in range(n-1,-n,-1):
    for x in range(0,n):
        y = x-i

        if y<0 or y>=n:
            continue
        else:
            if x>y:
                dp[x][y] = 0
            elif x-y==0:
                dp[x][y] = n*wines[x]
            else:
                yr = n-(y-x)
                dp[x][y] = max(wines[x]*yr+dp[x+1][y],wines[y]*yr+dp[x][y-1])


#print(dp)
print(dp[0][n-1])