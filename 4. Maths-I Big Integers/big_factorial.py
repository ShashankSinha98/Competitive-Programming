def fact(N):
    res = 1
    for i in range(1,N+1):
        res *= i
    
    return res


print(fact(100))
