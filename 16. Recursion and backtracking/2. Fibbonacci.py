def Fibb(n):

    if n<=0:
        return 0
    if n==1:
        return 1

    return Fibb(n-1)+Fibb(n-2)

print(Fibb(6))