# ax + by = c, I/P = a,b,c O/P = values of x and y
import sys
def gcd(a,b):
    return a if b==0 else gcd(b,a%b)

x = y = GCD = sys.maxsize
def extended_euclid(a,b):
    global x,y,GCD
    if b==0:
        x = 1
        y = 0
        GCD = a
        return

    extended_euclid(b,a%b)
    cX = y
    cY = x - (a//b)*y

    x = cX
    y = cY

def printAnotherSet(x,y,t):
    cx = x + (b//GCD)*t
    cy = y - (a//GCD)*t
    return cx, cy


a,b,c = [int(i) for i in input().split()]

if c%gcd(a,b)!=0:
    raise Exception("No integral x and y exist for given a,b and c")    

else:
    extended_euclid(a,b)
    k = c//gcd(a,b)
    for t in range(0,5):
        x, y = printAnotherSet(x,y,t)
        print("x:",k*x," y:",k*y)






