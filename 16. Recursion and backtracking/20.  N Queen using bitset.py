
LIM = 100
col = [True for i in range(LIM)]
left_diag = [True for i in range(LIM)]
right_diag = [True for i in range(LIM)]

board = [[0]*LIM for i in range(LIM)]

def n_queen_bits_1(rowBits,ld,rd,row):
    global ans,n

    if rowBits == DONE:
        for i in range(n):
            for j in range(n):
                print(board[i][j],end=" ")
            print()
        print()
        ans+=1
        return

    safe = DONE & (~(ld|rd|rowBits))

    while safe!=0:
        p = safe & (-safe)
        bitPos = bit_pos(p)
        board[row][bitPos] = 1
        safe = safe - p

        n_queen_bits_1(rowBits|p,(ld|p)<<1,(rd|p)>>1,row+1)

        board[row][bitPos] = 0




def n_queen_bits_2(row,n):
    global ans

    if row == n:
        ans+=1
        return

    for i in range(0,n):

        if(col[i] & left_diag[row-i+n] & right_diag[row+i]):
            col[i] = left_diag[row-i+n] = right_diag[row+i] = False

            n_queen_bits_2(row+1,n)

            col[i] = left_diag[row-i+n] = right_diag[row+i] = True



def bit_pos(n):
    ans = 0
    while n&1 != 1:
        ans+=1
        n=n>>1
    return ans

n = int(input()) 
DONE = (1<<n)-1

ans = 0
n_queen_bits_1(0,0,0,0)
#n_queen_bits_2(0,n)
print(ans)