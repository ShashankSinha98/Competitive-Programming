def ModPow(a,b,c):

    if b==0:
        return 1

    smallAns = ModPow(a,b//2,c)
    smallAns = (smallAns*smallAns) % c

    if b&1 == 0:
        return smallAns%c
    else:
        return (a*smallAns)%c


a,b,c = [int(i) for i in input().split()]
print(ModPow(a,b,c))