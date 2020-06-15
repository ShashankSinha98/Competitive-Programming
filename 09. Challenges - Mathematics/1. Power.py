a = int(input())
b = int(input())

def power(a,b):

    if b == 0:
        return 1
    
    elif b == 1:
        return a

    X = power(a,b//2)
    if (b&1)==1:
        return a*X*X
    else:
        return X*X

print(power(a,b))
