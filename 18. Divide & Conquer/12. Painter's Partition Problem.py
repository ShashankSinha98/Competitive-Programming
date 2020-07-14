import sys

def min_time(P,B,boards):

    # search space
    st = boards[B-1]
    end = sum(boards)
    ans = sys.maxsize

    while(st<=end):

        mid = (st+end)//2

        possible = possibleToPaint(P,B,boards,mid)

        if possible:
            end = mid-1
            ans = min(ans,mid)
        else:
            st = mid+1

    return ans


def possibleToPaint(P,B,boards,min_time):

    t = 0
    pntr_req = 1
    curr_sum = 0
    for b in boards:

        if curr_sum+b<=min_time:
            curr_sum+=b
        else:
            pntr_req+=1
            curr_sum = b

        #print(pntr_req)

    return pntr_req <= P

#print(possibleToPaint(100,7,[1,2,3,4,5,6,7],11))
    
    

P = int(input())
B = int(input())
boards = [int(i) for i in input().split()]

ans = min_time(P,B,boards)
print(ans)