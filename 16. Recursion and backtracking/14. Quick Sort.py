arr=[2,7,8,6,1,5,4]

def quick_sort(arr,st,end):


    if st>=end:
        return

    arr,p = partition(arr,st,end)

    quick_sort(arr,st,p-1)
    quick_sort(arr,p+1,end)


def partition(arr,st,end):

    pivot = arr[end]
    i = st-1

    for j in range(st,end):

        if arr[j]<=pivot:
            i+=1
            arr[i],arr[j] = arr[j],arr[i]

    arr[i+1],arr[end] = arr[end],arr[i+1]

    return arr,i+1


quick_sort(arr,0,len(arr)-1)
print(arr)