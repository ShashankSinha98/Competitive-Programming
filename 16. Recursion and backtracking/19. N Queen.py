

def n_queen(board,i,n):

    if i==n:
        for i in range(n):
            for j in range(n):
                print(board[i][j],end=" ")
            print()
        print()
        return False

    
    for j in range(0,n):

        #print_storage("A, j: "+str(j)+", i: "+str(i))
        if is_safe_opt(board,i,j,n):
            board[i][j] = 1

            set_storage(board,i,j,n)
            #print_storage("B, j: "+str(j)+", i: "+str(i))
        

            thisQueenPosIsValid = n_queen(board,i+1,n)

            if thisQueenPosIsValid:
                return True
        
            board[i][j] = 0

            unset_storage(board,i,j,n)
            #print_storage("C, j: "+str(j)+", i: "+str(i))

    return False

def print_storage(key):
    print('key: ',key)
    print("col: ",col)
    print("left_diag: ",left_diag)
    print("right_diag: ",right_diag)

def set_storage(board,i,j,n):
    col[j] += 1
    left_diag[i-j+n] += 1
    right_diag[abs(i+j)] += 1

def unset_storage(board,i,j,n):
    col[j] -= 1
    left_diag[i-j+n] -= 1
    right_diag[abs(i+j)] -= 1

def is_safe_opt(board,i,j,n):
    if col[j] > 0 or left_diag[i-j+n] > 0 or right_diag[i+j] > 0:
        return False
    else:
        return True


def is_safe(board,i,j,n):

    # Checking col-
    for row in range(0,i):
        if board[row][j]==1:
            return False

    # Checking Left Diagonal
    x = i
    y = j

    while x>=0 and y>=0:
        if board[x][y]==1:
            return False
        x-=1
        y-=1

    # Checking Right Diagonal
    x = i
    y = j

    while x<n and y<n:
        if board[x][y]==1:
            return False
        x-=1
        y+=1

    return True


    
n = int(input())
LIM = 100
col = [0 for i in range(LIM)]
left_diag = [0 for i in range(LIM)]
right_diag = [0 for i in range(LIM)]




board = [[0]*n for i in range(n)]

n_queen(board,0,n)