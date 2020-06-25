# Accepted
# See gfg for GP formula of sum of divisors

import math
LIM = 10**8+8

A = [0 for i in range(LIM)]

def divisors_sum(N):
    res = 1

    for i in range(2,int(math.sqrt(N)+1)):
        if N%i==0:
            a = 0
            while N%i==0:
                a+=1
                N//=i
            res*=((i**(a+1) - 1)//(i-1))
    if N>1:
        res*=((N**2-1)//(N-1))
    return res

A[1] = 1
for i in range(2,10**5+1):
    A[divisors_sum(i)] = i

while True:
    S = int(input())

    if S==0:
        break

    if A[S] !=0:
        print(A[S])
    else:
        print(-1)

