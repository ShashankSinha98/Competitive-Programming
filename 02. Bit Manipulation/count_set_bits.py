def count_set_bits(N):
    ans = 0

    while(N!=0):
        ans += (N&1)
        N = N>>1
    
    return ans 

def count_set_bits_optimised(N):
    ans = 0
    while(N!=0):
        N = N & (N-1)
        ans+=1
    return ans

print(count_set_bits(13)) # 1101 O(logn)
print(count_set_bits_optimised(5)) # 0101 O(no of set bits)
