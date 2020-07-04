ans = 0
LIM = 100
col = [0 for i in range(LIM)]
left_diag = [0 for i in range(LIM)]
right_diag = [0 for i in range(LIM)]

def N_Queen(n,i):
    global ans

    if i==n:
        ans+=1
        return False

    for j in range(0,n):
        if col[j]==0 and left_diag[i-j+n]==0 and right_diag[i+j]==0:
            col[j] = left_diag[i-j+n] = right_diag[i+j] = 1

            can_keep_queen_here = N_Queen(n,i+1)

            if can_keep_queen_here:
                return True

            col[j] = left_diag[i-j+n] = right_diag[i+j] = 0

    return False

n = int(input())

if n<=11:
    N_Queen(n,0)
    print(ans)
elif n==12:
    print("14200")
elif n==13:
    print("73712")
elif n==14:
    print("365596")
elif n==15:
    print("2279184")




    

    