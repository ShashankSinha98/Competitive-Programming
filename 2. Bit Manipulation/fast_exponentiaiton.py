def fast_expoentiation(a,b):

    res=1

    while(b!=0):
        bit = b & 1

        if bit==1:
            res=res*a
        
        a*=a
        b=b>>1
    
    return res

print(fast_expoentiation(3,5))