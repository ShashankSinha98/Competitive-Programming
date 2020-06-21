import sys
x = sys.maxsize
y = sys.maxsize
MAX_GCD = sys.maxsize


num = [int(i) for i in input().split()]
rem = [int(i) for i in input().split()]
n = len(num)
prod = 1
for i in num:
    prod*=i

pp = [ 0 for i in range(n)]
for i in range(n):
    pp[i] = prod//num[i]

inv = [ 0 for i in range(n)] 


def GCD(a,b):
    return a if b==0 else GCD(b,a%b)

def ExtendedEuclid(a,b):
    global x, y, MAX_GCD

    if b==0:
        x=1
        y=0
        MAX_GCD = a
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


for i in range(n):
    inv[i] = invModulo(pp[i],num[i])

res = 0

for i in range(n):
    res+=(rem[i] * pp[i] * inv[i])%prod

print(res)
