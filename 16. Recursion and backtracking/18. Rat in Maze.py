def find_paths(maze,out,i,j,m,n):

    if i==m and j==n:
        out[i][j] = 1
        for i in range(m+1):
            for j in range(n+1):
                print(out[i][j],end=" ")
            print()
        print()
        return True

    if i>m or j>n:
        return False

    if maze[i][j]==1:
        return False

    out[i][j] = 1
    
    rightPath = find_paths(maze,out,i,j+1,m,n)
    leftPath = find_paths(maze,out,i+1,j,m,n)

    out[i][j] = 0

    if leftPath or rightPath:
        return True

    

    return False


maze = [
    [0,0,0,0],
    [0,1,0,0],
    [0,0,0,1],
    [1,0,0,0] 
]

out = [[0]*len(maze) for i in range(len(maze))]

find_paths(maze,out,0,0,3,3)