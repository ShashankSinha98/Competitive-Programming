import sys
x = sys.maxsize
y = sys.maxsize
GCD = sys.maxsize

def GCD(a,b):
    return a if b==0 else GCD(b,a%b)

def ExtendedEuclid(a,b):
    global x, y, GCD

    if b==0:
        x=1
        y=0
        GCD = a
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


print(invModulo(6,7))