def bubble_sort(arr):

    for i in range(len(arr)-1):
        for j in range(0,len(arr)-i-1):
            if arr[j] > arr[j+1]:
                arr[j+1],arr[j] = arr[j], arr[j+1]

    return arr

arr = [5,4,3,2,1,-4,-10]
arr = bubble_sort(arr)
print(arr)