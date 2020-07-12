def binary_search(arr,k):

    left = 0
    right = len(arr)-1

    while(left<=right):

        mid = (left+right)//2

        if arr[mid]==k:
            return mid
        
        elif k>arr[mid]:
            left = mid+1
        
        else:
            right = mid-1

    return -1

arr  = [1,3,5,7,9,11]
k = 13
print(binary_search(arr,k))