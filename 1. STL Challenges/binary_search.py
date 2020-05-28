def binary_search(arr,k):
    left = 0
    right = len(arr)-1

    while(left<=right):
        mid = ((left+right)//2)
        
        if arr[mid] == k:
            return mid
        elif k>arr[mid]:
            left = mid+1
        else:
            right = mid-1


    return mid

    

def lower_bound(arr,k):
    left = 0
    right = len(arr)-1
    res = -1

    while(left<=right):
        mid = ((left+right)//2)
        
        if arr[mid] == k:
            res =  mid
            right = mid-1
        elif k>arr[mid]:
            left = mid+1
        else:
            right = mid-1
    return res

def upper_bound(arr,k):
    left = 0
    right = len(arr)-1
    res = -1

    while(left<=right):
        mid = ((left+right)//2)
        
        if arr[mid] == k:
            res =  mid
            left = mid+1
        elif k>arr[mid]:
            left = mid+1
        else:
            right = mid-1
    return res


print(lower_bound([1,2,5,9,12,12,12,14,18],12))
print(upper_bound([1,2,5,9,12,12,12,14,18],12))