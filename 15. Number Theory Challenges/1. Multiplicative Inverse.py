import sys
x = sys.maxsize
y = sys.maxsize

def GCD(a,b):
    return a if b==0 else GCD(b,a%b)

def ExtendedEuclid(a,b):
    global x,y

    if b==0:
        x = 1
        y = 0
        return

    ExtendedEuclid(b,a%b)
    cX = y
    cY = x - (a//b)*y
    
    x = cX
    y = cY




n = int(input())
m = 1000000007
ExtendedEuclid(n,m)
print((x+m)%m)