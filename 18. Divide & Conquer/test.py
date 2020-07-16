def inversion_count(arr,s,e):

    if(s>=e):
        return 0

    mid = (s+e)//2
    x = inversion_count(arr,s,mid)
    y = inversion_count(arr,mid+1,e)
    z = merge(arr,s,e)

    return x+y+z

def merge(arr,s,e):

    mid = (s+e)//2

    i = s
    j = mid+1
    karr = []
    cnt = 0

    while i<=mid and j<=e:

        if arr[i]<=arr[j]:
            karr.append(arr[i])
            i+=1
        else:
            karr.append(arr[j])
            cnt+=(mid-i+1)
            j+=1
    
    while i<=mid:
        karr.append(arr[i])
        i+=1

    while j<=e:
        karr.append(arr[i])
        j+=1

    for i in range(s,e+1):
        arr[i] = karr[i-s]

    return cnt


arr = [5,4,3,2,1]
print(inversion_count(arr,0,len(arr)-1))
