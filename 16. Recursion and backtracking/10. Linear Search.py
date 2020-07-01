def LinearSearch(arr,k,idx):

    if idx == len(arr):
        return -1

    if arr[idx] == k:
        return idx

    return LinearSearch(arr,k,idx+1)

arr = [1,5,2,9,7]
key = 0
print(LinearSearch(arr,key,0))
