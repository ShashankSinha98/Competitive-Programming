def unique_no_3(arr):

    sum_arr = [0]*64

    for i in arr:
        pos=0
        while(i!=0):
            bit=i&1
            sum_arr[pos]+=bit
            i = i>>1
            pos+=1
    
    sum_arr = [i%3 for i in sum_arr]
    
    res = 0
    p=0

    for i in sum_arr:
    
        if i == 1:
            res+=2**p
        p+=1 

    return res

    

n = int(input())
inp_arr = [int(i) for i in input().split()]
ans = unique_no_3(inp_arr)
print(ans)
        