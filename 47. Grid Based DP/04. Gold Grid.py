import sys
n, m = [int(i) for i in input().split()]

grid = [[0]*(n+1) for i in range(n+1)]

for i in range(m):
    x,y = [int(i) for i in input().split()]
    grid[x][y] = 1

def display(grid):

    for i in range(len(grid)):
        for j in range(len(grid)):
            print(grid[i][j],end=" ")
        print()
    print()

#display(grid)

for i in range(1,n+1):
    for j in range(1,n+1):
        if grid[i][j] == 1:
            grid[i][j] = grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1] + 1
        else:
            grid[i][j] = grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1]

#display(grid)

res = -sys.maxsize

for i in range(1,n+1):
    for j in range(1,n+1):

        a = grid[i][j]
        b = grid[i][n] - grid[i][j]
        c = grid[n][j] - grid[i][j]
        d = grid[n][n] - a - b - c

        res = max(res,min(a,b,c,d))


print(res)
