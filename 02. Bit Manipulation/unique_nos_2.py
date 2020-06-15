def unique_nos_2(arr):

    xor_res=0

    for i in arr:
        xor_res = xor_res ^ i

    pos=0
    temp=xor_res

    while(temp!=0):
        last_bit = temp&1
        if last_bit==1:
            break
        pos+=1
        temp=temp>>1
    
    temp_list = []
    for i in arr:
        if get_ith_bit(i,pos)==1:
            temp_list.append(i)
    
    unique_no_a = 0
    for i in temp_list:
        unique_no_a = unique_no_a ^ i

    unique_no_b = xor_res^unique_no_a

    if unique_no_a>unique_no_b:
        return unique_no_b,unique_no_a
    else:
        return unique_no_a,unique_no_b

def get_ith_bit(N,i):
    
    if N & (1<<i) != 0:
        return 1
    else:
        return 0

inp_arr = [2,2,3,7,5,5,1,1]

a,b = unique_nos_2(inp_arr)
print(a,b)