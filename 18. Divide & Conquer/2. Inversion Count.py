def inversion_count(arr):

    if len(arr)==1:
        return 0,arr

    mid = len(arr)//2
    x,left = inversion_count(arr[0:mid])
    y,right = inversion_count(arr[mid:])
    cross_inv,complete = merge(left,right)

    return x+y+cross_inv,complete


def merge(left,right):

    le = len(left)-1
    re = len(right)-1

    i,j,cnt = 0,0,0
    karr = []

    while i<=le and j<=re:
        if left[i]<right[j]:
            karr.append(left[i])
            i+=1
        else:
            karr.append(right[j])
            j+=1
            cnt += le-(i-1)

    while i<=le:
        karr.append(left[i])
        i+=1

    while j<=re:
        karr.append(right[j])
        j+=1

    return cnt,karr


t = int(input())

while t!=0:
    t-=1
    n = int(input())
    arr = [int(i) for i in input().split()]

    ans, sorted_arr = inversion_count(arr)
    print(ans)

