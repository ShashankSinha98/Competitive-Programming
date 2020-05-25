def get_ith_Bit(N,i):
    if N & (1<<i) != 0:
        return 1
    else:
        return 0

def clear_ith_bit(N,i):
    mask = ~(1<<i)
    return N & mask

def update_ith_bit(N,i,v):
    mask = ~(1<<i)
    N = N & mask
    return N | (v<<i)

def set_ith_bit(N,i):
    return N | (1<<i)

def is_odd_even(N):
    return N & 1 

def clear_last_i_bits(N,i):
    return N & (-1<<i)

def clear_range_of_bits(N,i,j):
    a = (-1<<(j+1))
    b = (1<<i)-1
    mask = a | b

    N = N & mask
    return N


print("Get 2nd Bit of 5:",get_ith_Bit(5,2))
print("Set 1st bit of 5:",set_ith_bit(5,1))
print("If 5 is odd/even:",is_odd_even(5))
print("Update 1st bit of 5 to 1:",update_ith_bit(5,1,1))
print("Clear 0th bit of 5:",clear_ith_bit(5,0))
print("Clear last 3(from 0 to 2nd pos) bits of 15:",clear_last_i_bits(15,2))
print("Clear bits of 63 from 2nd to 4th pos:",clear_range_of_bits(63,2,4))

