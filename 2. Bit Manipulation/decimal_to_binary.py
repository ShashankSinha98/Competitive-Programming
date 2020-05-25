def decimal_to_binary(N):
    ans = 0
    p=1
    
    while(N!=0):
        last_bit = N&1
        ans += p*last_bit
        p*=10
        N = N>>1
    
    return ans

print(decimal_to_binary(13)) #1101
print(decimal_to_binary(23)) #10111