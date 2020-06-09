
def multiply(A,B):
        
    res = [[0]*(k+1) for i in range(k+1)]

    for i in range(k+1):
        for j in range(k+1):
            temp = 0
            for x in range(k+1):
                temp = (temp + (A[i][x]*B[x][j]))
            res[i][j] = temp
    return res


def power(T,n):

    if n==1:
        return T

    if n&1:
        return multiply(T,power(T,n-1))

    X = power(T,n//2)
    return multiply(X,X)


def transformation_matrix(c):
    k = len(c)
    T = [[0]*(k+1) for i in range(k+1)]
    T[0][0] = 1

    for i in range(k+1):
        for j in range(1,k+1):

            if i==0:
                T[i][j] = c[k-j]
            elif i<k:
                if j == i+1:
                    T[i][j] = 1
            else:
                T[i][j] = c[k-j]
    return T

t = int(input())

for i in range(t):

    k = int(input())
    b = [int(i) for i in input().split()]
    c = [int(i) for i in input().split()]
    arr = [int(i) for i in input().split()]
    m,n,p = arr

    F1 = [0 for i in range(k+1)]

    for i in range(k):
        F1[0] += b[i]
    
    for i in range(1,k+1):
        F1[i] = b[i-1]

    print("F1",F1)

    T = transformation_matrix(c)
    print("T",T)

    sum_m = 0
    if m<=k+1:
        for i in range(m-1):
            sum_m += F1[i+1]
    else:
        T_m = power(T,m-2)
        print("T_m",T_m)
        for i in range(k+1):
            sum_m += (T_m[0][i]*F1[i])

    sum_n = 0
    if n<=k:
        for i in range(n):
            sum_n += F1[i+1]
    else:
        T_n = power(T,n-2)
        print("T_n",T_n)
        for i in range(k+1):
            sum_n += (T_n[0][i]*F1[i])

    print(sum_m,sum_n)
    print((sum_n-sum_m)%p)




