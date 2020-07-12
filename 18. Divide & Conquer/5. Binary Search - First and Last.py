def first_occ(arr,k):

    ans = -1
    st = 0
    end = len(arr)-1

    while (st<=end):

        mid = (st+end)//2

        if arr[mid] == k:
            ans = mid
            end = mid-1

        elif k > arr[mid]:
            st = mid+1
        else:
            end = mid-1

    return ans

def last_occ(arr,k):

    ans = -1
    st = 0
    end = len(arr)-1

    while (st<=end):

        mid = (st+end)//2

        if arr[mid] == k:
            ans = mid
            st = mid+1

        elif k > arr[mid]:
            st = mid+1
        else:
            end = mid-1

    return ans

arr = [1,2,5,5,5,9,10]
k = 5
print(first_occ(arr,k))
print(last_occ(arr,k))
