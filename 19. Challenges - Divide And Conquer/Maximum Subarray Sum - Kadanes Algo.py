def maxSubArr(arr):

    max_res = 0
    max_till = 0

    for i in arr:
        max_till+=i

        if max_till>max_res:
            max_res = max_till

        if max_till < 0:
            max_till = 0
        
    return max_res



t = int(input())

while t!=0:
    t-=1

    n = int(input())
    arr = [int(i) for i in input().split()]

    ans = maxSubArr(arr)
    print(ans)