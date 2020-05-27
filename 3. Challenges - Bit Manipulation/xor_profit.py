a = int(input())
b = int(input())

def dec_to_bin(N):
    res=[0]*64
    
    pos=0
    while N!=0:
        last_bit = N & 1
        res[pos] = last_bit
        pos+=1
        N=N>>1
    return res

def max_xor(a,b):
    a_bin = dec_to_bin(a)
    b_bin = dec_to_bin(b)
    #print(a_bin)
    #print(b_bin)

    res = ""
    x = ""
    y = ""
    diff_pt_found = False

    for i in range(len(a_bin)-1,-1,-1):

        if diff_pt_found == False and a_bin[i] == b_bin[i]:
            x+=str(a_bin[i])
            y+=str(b_bin[i])

        if diff_pt_found == False and a_bin[i] != b_bin[i]:
            diff_pt_found = True
            x+=str(a_bin[i])
            y+=str(b_bin[i])
            #print("Diff Pt.",i)
            res+="1"
            continue
        
        if diff_pt_found == True:
            if a_bin[i] != b_bin[i]:
                res+="1"
                x+=str(a_bin[i])
                y+=str(b_bin[i])
            elif b_bin[i]==1:
                res+="1"
                # y+="0"
                x+=str(a_bin[i])
                y+=str(0)
            elif a_bin[i]==0:
                res+="1"
                #x+="1"
                x+=str(1)
                y+=str(b_bin[i])

    #print(len(x))
    return x,y,res

def bin_to_dec(bin):
    bin = str(bin)
    mul = 1
    res=0
    for i in range(len(bin)-1,-1,-1):
        if bin[i]=='1':
            res+=mul
            
        mul=mul*2
        
    return res


x,y,res = max_xor(a,b)
#print("X:",x)
#print(bin_to_dec(x))
#print("Y:",y)
#print(bin_to_dec(y))
#print("Res:",res)
print(bin_to_dec(res))