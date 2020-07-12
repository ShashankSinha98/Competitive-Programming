def square_root_bin(n,p):

    st = 1
    end = n

    bef_dec = 0

    while(st<=end):
        
        mid = (st+end)//2

        if mid*mid == n:
            bef_dec = mid
            break
        elif (mid*mid)>n:
            end = mid-1
        else:
            bef_dec = mid
            st = mid+1


    curr_no = bef_dec

    if curr_no*curr_no == n:
        return curr_no


    inc = 0.1
    k = p
    while k!=0:
        k-=1
        while curr_no*curr_no <=n:
            curr_no += inc
        curr_no -= inc
        inc = inc/10


    return round(curr_no,p)
    
n = int(input())
print(square_root_bin(n,3))
