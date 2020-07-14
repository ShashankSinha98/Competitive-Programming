# TLE on SPOJ

def min_height(T,W,trees):

    # search space
    st = 0
    end = max(trees)

    ans = -1

    while(st<=end):

        mid = (st+end)//2

        fullfilled = woodRequirementOver(T,W,trees,mid)

        if fullfilled:
            ans = max(ans,mid)
            st = mid+1
        else:
            end = mid-1

    return ans


def woodRequirementOver(T,W,trees,height):

    woods = 0
    for t in trees:
        rem = t-height
        if rem>0:
            woods+=rem
        
    return woods>=W
        



T, W = [int(i) for i in input().split()]
trees = [int(i) for i in input().split()]

ans = min_height(T,W,trees)
print(ans)