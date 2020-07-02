def bubbleLinear(arr):

    n = len(arr)

    for i in range(0,n-1):
        for j in range(0,n-i-1):

            if arr[j]>arr[j+1]:
                arr[j],arr[j+1] = arr[j+1],arr[j]

    return arr


def bubble_partial_recc(arr,i):

    if i==len(arr)-1:
        return arr

    for j in range(0,len(arr)-i-1):
        if arr[j]>arr[j+1]:
            arr[j],arr[j+1] = arr[j+1],arr[j]

    return bubble_partial_recc(arr,i+1)


def bubble_complete_recc(arr,i,j):

    n = len(arr)
    if i==n-1:
        return arr
    
    if j==n-i-1:
        return bubble_complete_recc(arr,i+1,0)

    if arr[j]>arr[j+1]:
        arr[j],arr[j+1] = arr[j+1],arr[j]

    return bubble_complete_recc(arr,i,j+1)


arr = [5,4,3,2,1,6,9]
print(bubble_complete_recc(arr,0,0))


