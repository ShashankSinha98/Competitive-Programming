def max_scholarship(N,M,X,Y):

    # search space
    st = 0
    end = N

    ans = -1

    while (st<=end):

        mid = (st+end)//2

        if mid*X <= M + (N-mid)*Y:
            ans = max(ans,mid)
            st = mid+1
        else:
            end = mid-1

    return ans


N,M,X,Y = [int(i) for i in input().split()]
ans = max_scholarship(N,M,X,Y)
print(ans)