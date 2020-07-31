import sys
def minPagePossible(arr,N,M,min_pages):

    pagesReading = 0
    studentUsed = 1
    for i in range(0,N):

        if (pagesReading+arr[i]>min_pages):
            studentUsed+=1

            pagesReading = arr[i]

            if studentUsed > M:
                return False
        else:
            pagesReading+=arr[i]
    return True    


def solve(arr,N,M):

    # Defining search space
    st = arr[N-1]
    end = sum(arr)

    ans = sys.maxsize

    while(st<=end):
        mid = (st+end)//2

        minPageHoPaye = minPagePossible(arr,N,M,mid) 
        if minPageHoPaye:
            end = mid-1
            ans = min(mid,ans)
        else:
            st = mid+1

    return ans


N,M = [int(i) for i in input().split()]
arr = [int(i) for i in input().split()]

print(solve(arr,N,M))

