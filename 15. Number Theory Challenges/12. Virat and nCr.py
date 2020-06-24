import sys
x = sys.maxsize
y = sys.maxsize

def GCD(a,b):
    return a if b==0 else GCD(b,a%b)

def ExtendedEuclid(a,b):
    global x, y

    if b==0:
        x=1
        y=0
        return

    ExtendedEuclid(b,a%b)
    cX = y
    cY = x - (a//b)*y

    x = cX
    y = cY

def invModulo(a,m):
    if GCD(a,m) != 1:
        raise Exception('No inverse modulo exist for given a and m')
    else:
        ExtendedEuclid(a,m)
        return (x+m)%m


MOD = 1000000007
n,r = [int(i) for i in input().split()]

if r > n-r:
    r = n-r 

ans = 1
for i in range(r):
    ans = (ans* (n-i))%MOD
    ans = (ans * invModulo((r-i),MOD))%MOD

print(round(ans))
