def isSortedhalf(arr):
    n = len(arr)

    if n==1:
        return True
    
    if n==2:
        return arr[0]<arr[1]

    return isSortedhalf(arr[:n//2]) and isSortedhalf(arr[n//2:])


def isSortedminusOne(arr):

    if len(arr)==1:
        return True

    return (arr[0]<arr[1]) and isSortedminusOne(arr[1:])

print(isSortedminusOne([1,2,3,4,9]))