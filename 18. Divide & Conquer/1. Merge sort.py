def merge_sort(arr,n):

    if len(arr)== 1:
        return arr
    
    mid = len(arr)//2
    left = merge_sort(arr[0:mid],n)
    right = merge_sort(arr[mid:],n)

    complete = merge(left,right)
    return complete


def merge(left,right):

    ls = 0
    le = len(left)-1

    rs = 0
    re = len(right)-1

    karr = []
    i,j = 0,0

    while i<=le and j<=re:
        
        if left[i] < right[j]:
            karr.append(left[i])
            i+=1
        else:
            karr.append(right[j])
            j+=1

    while i<=le:
        karr.append(left[i])
        i+=1

    while j<=re:
        karr.append(right[j])
        j+=1

    return karr
        


arr = [5,4,3,2,1,7,9,25,20]
n = len(arr)
arr = merge_sort(arr,n)
print(arr)