def solve(arr,i,j,m,n):

    if i==m-1 and j==n-1:
        arr[m-1][n-1] = 1
        for x in range(m):
            for y in range(n):
                print(arr[x][y],end=" ")
            print()
        print()
        arr[m-1][n-1] = 0
        return

    
    if i>=m or j>=n:
        return
    
    arr[i][j] = 1
    # Move Right
    solve(arr,i+1,j,m,n)
    # Move Down
    solve(arr,i,j+1,m,n)

    arr[i][j] = 0


m,n = [int(i) for i in input().split()]
arr = [[0]*n for i in range(m)]

solve(arr,0,0,m,n)