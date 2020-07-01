def WaysOfTiling(n):

    if n==4:
        return 2

    if n<4:
        return 1

    return WaysOfTiling(n-1) + WaysOfTiling(n-4)


print(WaysOfTiling(5))