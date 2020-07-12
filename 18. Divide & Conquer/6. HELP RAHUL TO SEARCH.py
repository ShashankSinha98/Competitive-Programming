def find(arr,k):

    st = 0
    end = len(arr)-1

    while st<=end:

        mid = (st+end)//2

        if arr[mid]==k:
            return mid

        elif arr[st]<=arr[mid]:

            if arr[st]<= k <= arr[mid]:
                end = mid-1
            else:
                st = mid+1

        elif arr[mid]<=arr[end]:
            if arr[mid]<= k <=arr[end]:
                st = mid+1
            else:
                end = mid-1

    return -1

n = int(input())

arr = []
for i in range(n):
    arr.append(int(input()))

k = int(input())

print(find(arr,k))



