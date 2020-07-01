def increasing(n):

    if n==0:
        return

    increasing(n-1)
    print(n)

#increasing(10)

def decreasing(n):

    if n==0:
        return

    print(n)
    decreasing(n-1)

decreasing(10)
    