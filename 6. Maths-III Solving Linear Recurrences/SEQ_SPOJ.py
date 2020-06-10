# Causing TLE on SPOJ
t = int(input())

for i in range(t):
    
    k = int(input())
    b = [int(i) for i in input().split()]
    c = [int(i) for i in input().split()]
    n = int(input())

    MOD = 1000000000

    compute(k,b,c,n)

    def multiply(A,B):
        
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

    #print(power([[1,2],[3,4]],10,2))


    def transformation_matrix(k,c):

        T = [[0]*(k) for i in range(k)]
        
        for i in range(k):
            for j in range(k):
                if i<k-1:
                    if i+1 == j:
                        T[i][j] = 1
                    else:
                        T[i][j] = 0

                else:
                    T[i][j] = c[k-j-1]

        return T


    def compute(k,b,c,n):

        if n<=k:
            return b[n-1]
        
        T = transformation_matrix(k,c)

        T_pow = power(T,n-1)

        res = 0
        for i in range(k):
            res = (res + (T_pow[0][i]*b[i])%MOD)%MOD
            
        print(res)


    



    #print(multiply([[3,4],[2,1]],[[1,5],[3,7]],2))
            
    #print(transformation_matrix(3,[1,2,3]))

