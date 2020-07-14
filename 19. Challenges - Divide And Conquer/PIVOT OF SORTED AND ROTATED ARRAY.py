def pivot(arr,n):

    st = 0
    end = n-1

    while(st<=end):

        mid = (st+end)//2

        if(mid+1<=n and arr[mid]>arr[mid+1]):
            return mid

        if(mid-1>=0 and arr[mid-1]>arr[mid]):
            return mid-1
        
        if arr[st]>arr[mid]<arr[end]:
            end = mid-1
        else:
            st = mid+1

    return -1




t = 1

while t!=0:
    t-=1
    arr = []
    n = int(input())
    for i in range(n):
        arr.append(int(input()))

    ans = pivot(arr,n-1)
    print(ans)