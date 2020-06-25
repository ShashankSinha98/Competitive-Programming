# Accepted
# No Modular Multiplicationn required in Python. Works well for 2^63-1

import random

def miller_rabin(N,d):

    a = 2+int(random.random()*((N-2 -2)+1))

    x = modular_exponentiation(a,d,N)

    if x%N==1 or x == N-1:
        return True

    while d!=N-1:
        x = (x*x)%N
        d = d*2

        if x==1:
            return True
        if x==N-1:
            return True

    return False


def modular_exponentiation(a,d,n):
    res = 1

    while d!=0:
        if(d&1==1):
            res = (a*res)%n
        a = (a*a)%n
        d = d>>1

    return res

    




def isPrime(N,k):

    if N==2:
        return True

    if N<=1 or N%2==0:
        return False

    d = N-1
    while d%2==0:
        d//=2
    
    for i in range(0,k):
        if(not miller_rabin(N,d)):
            return False
    return True



t = int(input())

while t!=0:
    t-=1

    N = int(input())

    if isPrime(N,5):
        print("YES")
    else:
        print("NO")
