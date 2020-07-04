
LIM = 100
col = [True for i in range(LIM)]
left_diag = [True for i in range(LIM)]
right_diag = [True for i in range(LIM)]

def n_queen_bits_1(rowBits,ld,rd,row):
    global ans

    if rowBits == DONE:
        ans+=1
        return

    safe = DONE & (~(ld|rd|rowBits))

    while safe!=0:
        p = safe & (-safe)
        safe = safe - p

        n_queen_bits_1(rowBits|p,(ld|p)<<1,(rd|p)>>1,row+1)




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





n = int(input()) 
DONE = (1<<n)-1

ans = 0
n_queen_bits_1(0,0,0,0)
#n_queen_bits_2(0,n)
print(ans)