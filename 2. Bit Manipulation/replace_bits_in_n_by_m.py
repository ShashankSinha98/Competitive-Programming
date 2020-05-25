def clear_range_of_bits(N,i,j):
    a = (-1<<(j+1))
    b = (1<<i)-1
    mask = a | b

    N = N & mask
    return N

def replaceBits(N,M,i,j):
    N = clear_range_of_bits(N,i,j)
    N = N | (M<<i)
    return N

print(replaceBits(15,2,1,3))