# Acepted on Codeforces
# ax + by = c, I/P = a,b,c O/P = values of x and y
import sys
def GCD(a,b):
    return a if b==0 else GCD(b,a%b)

x = y = sys.maxsize
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

def invModulo(a,m):
    if GCD(a,m) != 1:
        raise Exception('No inverse modulo exist for given a and m')
    else:
        ExtendedEuclid(a,m)
        return (x+m)%m



n,p,w,d = [int(i) for i in input().split()]

if p%GCD(w,d)!=0:
    print("-1") 
elif n*w < p:
    print("-1") 
else:
    g = GCD(w,d)

    p//=g
    w//=g
    d//=g

    y =  ( (p%w) * invModulo(d,w) )%w
    x = (p-y*d)//w

    if x+y > n:
        print("-1")
        
    
    elif x<0:
        print("-1")

    else:
        z = n-(x+y)
        print(x,y,z)