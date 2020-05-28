def bin_to_dec(bin):
    bin = str(bin)
    mul = 1
    res=0
    for i in range(len(bin)-1,-1,-1):
        if bin[i]=='1':
            res+=mul
            
        mul=mul*2
        
    return res

print(bin_to_dec("1101100"))
#89
#108