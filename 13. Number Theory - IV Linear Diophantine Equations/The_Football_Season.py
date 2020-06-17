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



n,p,w,d = [int(i) for i in input().split()]

if p%gcd(w,d)!=0:
    print("-1") 

else:
    extended_euclid(w,d)
    k = p//gcd(w,d)
    print(x,y)
    print(k*x,k*y)
    if x<0 or y<0:
        print("-1")
    elif k*x + k*y > n:
        print("-1")
    else:
        z = n - (k*x+k*y)
        print(k*x,k*y,z)
        






