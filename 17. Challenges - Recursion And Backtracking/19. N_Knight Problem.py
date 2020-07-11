def solve(board,i,j,p,n):
    global sieve,ans,res

    # base case
    if p==n:
        ans+=1
        temp = ""
        for r in range(n):
            for c in range(n):
                if board[r][c] == 1:
                    temp += "{"+str(r)+"-"+str(c)+"} "
                
                #print(board[r][c],end=" ")
            #print()
        #print()
        res.append(temp)
        return False
    
    
    if i>=n:
        return False


    if j >= n:
        return solve(board,i+1,0,p,n)

    if issafe(i,j):
        board[i][j] = 1
        markLoc(i,j,n)
        #print("S: ",sieve)
        #print("B: ",board)
        placeCorrect = solve(board,i,j+1,p+1,n)

        if placeCorrect:
            return True

        board[i][j] = 0
        unmarkLoc(i,j,n)
    
    return solve(board,i,j+1,p,n)

    


def issafe(i,j):
    return sieve[i][j]==0

def markLoc(i,j,n):
    global sieve
    if i+2<n and j+1<n:
        sieve[i+2][j+1] += 1

    if i+2<n and j-1>=0:
        sieve[i+2][j-1] += 1
    
    if i+1<n and j+2<n:
        sieve[i+1][j+2] += 1
    
    if i+1<n and j-2>=0:
        sieve[i+1][j-2] += 1

    if i-2>=0 and j+1<n:
        sieve[i-2][j+1] += 1

    if i-2>=0 and j-1>=0:
        sieve[i-2][j-1] += 1

    if i-1>=0 and j+2<n:
        sieve[i-1][j+2] += 1

    if i-1>=0 and j-2>=0:
        sieve[i-1][j-2] += 1



def unmarkLoc(i,j,n):
    global sieve
    if i+2<n and j+1<n:
        sieve[i+2][j+1] -= 1

    if i+2<n and j-1>=0:
        sieve[i+2][j-1] -= 1
    
    if i+1<n and j+2<n:
        sieve[i+1][j+2] -= 1
    
    if i+1<n and j-2>=0:
        sieve[i+1][j-2] -= 1

    if i-2>=0 and j+1<n:
        sieve[i-2][j+1] -= 1

    if i-2>=0 and j-1>=0:
        sieve[i-2][j-1] -= 1

    if i-1>=0 and j+2<n:
        sieve[i-1][j+2] -= 1

    if i-1>=0 and j-2>=0:
        sieve[i-1][j-2] -= 1




n = int(input())
board = [[0]*n for i in range(n)]
sieve = [[0]*n for i in range(n)]
ans = 0
res = []
solve(board,0,0,0,n)
for i in res:
    print(i,end=" ")
print()
print(ans)