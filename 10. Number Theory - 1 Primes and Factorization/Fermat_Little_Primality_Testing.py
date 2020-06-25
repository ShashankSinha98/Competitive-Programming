# Checking Primality using Fermat Little Theorem
# Accpeted on GFG, Link- https://practice.geeksforgeeks.org/problems/prime-number/0


import random


def GCD(a,b):
    return a if b==0 else GCD(b,a%b)

def BitPowMod(a,b,MOD):

    res = 1
    while b!=0:
        
        if b&1 == 1:
            res = (res * a)%MOD
        
        a = (a*a)%MOD
        b = b>>1

    return res

T = int(input())

while(T!=0):
    T-=1
    N = int(input())

    if N<=1 or N&1==0:
        print("No")
    elif N==2:
        print("Yes")
    else:
        k = 5
        prime = True
        for i in range(k):
            a = random.randint(2,N-1)
            if GCD(a,N)!=1:
                prime=False
                break
            
            if BitPowMod(a,N-1,N)!=1:
                prime = False
                break
        
        if prime:
            print("Yes")
        else:
            print("No")


    