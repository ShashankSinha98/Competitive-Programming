import sys
x = sys.maxsize
y = sys.maxsize
GCD = sys.maxsize

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

ExtendedEuclid(15,25)
print(x,y,GCD)
