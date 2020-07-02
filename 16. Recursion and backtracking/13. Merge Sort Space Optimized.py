arr=[5,4,3,2,1,6,9,20,15,32]


def divide(st,end):
    global arr

    # base case 
    if st == end:
        return arr

    mid = (st+end)>>1

    divide(st,mid)
    divide(mid+1,end)

    return merge(arr,st,end)

def merge(arr,st,end):

    mid = (st+end)>>1
    k = []
    i=st
    j=mid+1
    
    while i<=mid and j<=end:
        if arr[i]<arr[j]:
            k.append(arr[i])
            i+=1
        else:
            k.append(arr[j])
            j+=1
    
    while i<=mid:
        k.append(arr[i])
        i+=1

    while j<=end:
        k.append(arr[j])
        j+=1

    for i in range(st,end+1):
        arr[i] = k[i-st]

    return arr

   

print(divide(0,len(arr)-1))

    