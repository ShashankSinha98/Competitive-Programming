a = int(input())
b = int(input())

def fast_exp(a,b):

    if b==0:
        return 1

    if (b&1):
        return a*((fast_exp(a,b//2))**2)
    else:
        return ((fast_exp(a,b//2))**2)

print(fast_exp(a,b))