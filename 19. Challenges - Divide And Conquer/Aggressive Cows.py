
def canPlaceCow(arr,n,c,min_sep):

    cnt = 1
    lastCowBarn = arr[0]

    for i in range(1,n):
        if arr[i] - lastCowBarn >= min_sep:
            cnt+=1
            lastCowBarn = arr[i]

            if cnt == c:
                return True

    return False


def min_dist(arr,n,c):

    arr.sort()

    # Search space
    st = 0
    end = arr[n-1] - arr[0]
    ans = 0

    while(st<=end):

        mid = (st+end)//2

        cowsRakhPaye = canPlaceCow(arr,n,c,mid)

        if cowsRakhPaye:
            st = mid+1
            ans = mid

        else:
            end = mid-1

    return ans


t = 1

while t!=0:
    t-=1
    n,c = [int(i) for i in input().split()]
    arr = [int(i) for i in input().split()]

    ans = min_dist(arr,n,c)
    print(ans)
