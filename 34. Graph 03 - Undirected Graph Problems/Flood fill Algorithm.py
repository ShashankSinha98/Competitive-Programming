# https://practice.geeksforgeeks.org/problems/flood-fill-algorithm/0


def solve_grid(grid,x,y):
    global n,m,k,c
    if x<0 or y<0 or x>=n or y>=m:
        return

    if grid[x][y] != c:
        return
    
    grid[x][y] = k

    solve_grid(grid,x+1,y)
    solve_grid(grid,x,y+1)
    solve_grid(grid,x-1,y)
    solve_grid(grid,x,y-1)



t = int(input())

while t!=0:
    t-=1

    n,m = [int(i) for i in input().split()]
    grid = [[0]*m for i in range(n)]
    
    inp_arr = [int(i) for i in input().split()]

    k = 0
    for i in range(n):
        for j in range(m):
            grid[i][j] = inp_arr[k]
            k+=1

    x,y,k = [int(i) for i in input().split()]
    c = grid[x][y]

    solve_grid(grid,x,y)

    for i in range(n):
        for j in range(m):
            print(grid[i][j],end=" ")
    print()
    
