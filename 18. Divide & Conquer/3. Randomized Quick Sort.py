# TLE in 2nd test case, Code correct
import random
def quick_sort(arr,i,j,n):

    if i>=j:
        return 


    p = partition(arr,i,j)

    quick_sort(arr,i,p-1,n)
    quick_sort(arr,p,n-1,n)


def partition(arr,st,end):

    r = random.randint(st,end)
    arr[r],arr[end] = arr[end],arr[r]

    pivot = arr[end]

    j = st-1

    for i in range(st,end):

        if arr[i] <= pivot:
            j+=1
            arr[i],arr[j] = arr[j], arr[i]
                

    arr[j+1],arr[end] = arr[end],arr[j+1]
    return j+1


n = int(input())
arr = [int(i) for i in input().split()]
quick_sort(arr,0,n-1,n)
print(arr)