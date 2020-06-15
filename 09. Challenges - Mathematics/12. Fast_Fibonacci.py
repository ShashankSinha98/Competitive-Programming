t = int(input())

MOD = 1000000007


def multiply(A,B):

    k = len(A)

    res = [[0]*k for i in range(k)]

    for i in range(k):
        for j in range(k):
            temp = 0
            for x in range(k):
                temp = (temp + (A[i][x]*B[x][j])%MOD)%MOD
            res[i][j] = temp
    return res


def power(T,n):

    if n==1:
        return T

    if n&1:
        return multiply(T,power(T,n-1))

    X = power(T,n//2)
    return multiply(X,X)

while t!=0:
    t-=1
    n = int(input())

    T = [[0,1],[1,1]]
    b = [1,1]

    if n<=2:
        print("1")
    else:
        T = power(T,n-1)

        res = 0
        for i in range(len(T)):
            res = (res+(T[0][i]*b[i])%MOD)%MOD

        print(res)
