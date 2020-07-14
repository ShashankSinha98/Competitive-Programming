import sys

def maxCommon(arr,st,mid,end):

    left_max = -sys.maxsize
    curr_sum = 0
    for i in range(mid,st-1,-1):
        curr_sum+=arr[i]

        if curr_sum>left_max:
            left_max = curr_sum



    right_max = -sys.maxsize
    curr_sum = 0
    for i in range(mid+1,end+1):
        curr_sum+=arr[i]

        if curr_sum>right_max:
            right_max = curr_sum

    return max(left_max,right_max,left_max + right_max)



def maxSubArr(arr,st,end):

    if(st==end):
        return arr[st]


    mid = (st+end)//2

    left = maxSubArr(arr,st,mid)
    right = maxSubArr(arr,mid+1,end)
    common = maxCommon(arr,st,mid,end)

    return max(left,right,common) 


















t = int(input())

while t!=0:
    t-=1

    n = int(input())
    arr = [int(i) for i in input().split()]

    ans = maxSubArr(arr,0,n-1)
    print(ans)