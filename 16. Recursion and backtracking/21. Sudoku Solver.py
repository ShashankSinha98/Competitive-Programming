def sudoku_solver(sudoku,i,j,n):

    if i==n:
        for i in range(0,n):
            for j in range(0,n):
                print(sudoku[i][j],end=" ")
            print()
        return True

    if j>=n:
        return sudoku_solver(sudoku,i+1,0,n)

    if sudoku[i][j]!=0:
        return sudoku_solver(sudoku,i,j+1,n)

    for number in range(1,n+1):

        if can_place(sudoku,i,j,n,number):
            sudoku[i][j] = number

            can_sudoku_solve = sudoku_solver(sudoku,i,j+1,n)

            if can_sudoku_solve:
                return True
    
    sudoku[i][j] = 0

    return False


def can_place(sudoku,i,j,n,number):

    for k in range(0,n):
        if sudoku[i][k] == number or sudoku[k][j] == number:
            return False

    rs = (i//3)*3
    cs = (j//3)*3

    for r in range(rs,rs+3):
        for c in range(cs,cs+3):
            if sudoku[r][c] == number:
                return False

    return True


sudoku = [[0,2,0,5,0,1,0,9,0],
          [8,0,0,2,0,3,0,0,6],
          [0,3,0,0,6,0,0,7,0],
          [0,0,1,0,0,0,6,0,0],
          [5,4,0,0,0,0,0,1,9],
          [0,0,2,0,0,0,7,0,0],
          [0,9,0,0,3,0,0,8,0],
          [2,0,0,8,0,4,0,0,7],
          [0,1,0,9,0,7,0,6,0]]

sudoku_solver(sudoku,0,0,9)