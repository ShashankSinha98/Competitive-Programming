import sys

def pairs(arr,n,m):

    min_diff = sys.maxsize

    a,b = -1,-1

    for i in range(0,n-1):
        for j in range(i+1,n):

            if(arr[i]+arr[j]==m):

                diff = arr[j] - arr[i]

                if diff < min_diff:
                    min_diff = diff
                    a,b = arr[i],arr[j]
    
    return a,b



t = int(input())

while t!=0:
    t-=1
    n = int(input())
    arr = [int(i) for i in input().split()]
    arr.sort()
    M = int(input())

    a,b = pairs(arr,n,M)
    print("Deepak should buy roses whose prices are %d and %d."%(a,b))