def divide(arr):

    if len(arr)==1:
        return arr

    n = len(arr)

    a = divide(arr[:n//2])
    b = divide(arr[n//2:])
    c = merge(a,b)

    return c


def merge(a,b):

    c = []

    la,lb = len(a),len(b)
    i,j=0,0

    while i<la and j<lb:
        if a[i]<b[j]:
            c.append(a[i])
            i+=1
        else:
            c.append(b[j])
            j+=1

    while i<la:
        c.append(a[i])
        i+=1

    while j<lb:
        c.append(b[j])
        j+=1

    return c    

arr = [3,2,1,5,3,9]
print(divide(arr))
    