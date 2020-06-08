import math

def nth_fibb(N):

    a = math.pow(((1+math.sqrt(5))/2),N) 
    b = math.pow(((1-math.sqrt(5))/2),N)

    res = (a-b)/math.sqrt(5)

    return int(res)

print(nth_fibb(9))
