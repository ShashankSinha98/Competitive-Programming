def BinarySearch(arr,k,l,r):

    if l>r:
        return -1

    mid = (l+r)>>1

    if arr[mid]==k:
        return mid

    if k > arr[mid]:
        return BinarySearch(arr,k,mid+1,r)
    else:
        return BinarySearch(arr,k,l,mid-1)


arr = [1,2,3,4,5]
key = 2
print(BinarySearch(arr,key,0,len(arr)-1))