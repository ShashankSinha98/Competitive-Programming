arr = [5,4,3,2,1]

def quick_sort(arr,st,end):

    if st>=end:
        return

    p = partition(arr,st,end)

    quick_sort(arr,st,p-1)
    quick_sort(arr,p+1,end)


def partition(arr,st,end):

    p = arr[end]
    i = st-1

    for j in range(st,end):

        if arr[j] <= p:
            i+=1
            arr[i],arr[j] = arr[j],arr[i]

    arr[i+1],arr[end] = arr[end],arr[i+1]

    return i+1

        

quick_sort(arr,0,len(arr)-1)

print(arr)