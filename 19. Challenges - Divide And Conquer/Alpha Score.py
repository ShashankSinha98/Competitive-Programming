MOD = 1000000007

def cross_alpha_score(left,right):

    le = len(left)-1
    re = len(right)-1

    i,j,cnt = 0,0,0
    karr = []
    score = 0

    while i<=le and j<=re:

        if left[i]<right[j]:
            karr.append(left[i])
            score = (score + (left[i]*(re-j+1))%MOD)%MOD
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

    #print("s: ",score,"L: ",left,"R: ",right)
    
    
    return score%MOD,karr

        

def sub_sum(arr,i,j):

    res = 0
    for k in range(i,j+1):
        res=(res+arr[k])%MOD

    return res%MOD




def alpha_score(arr,st,end):

    if(st>=end):
        return 0,[arr[st]]

    mid = (st+end)//2

    x,left = alpha_score(arr,st,mid)
    y,right = alpha_score(arr,mid+1,end)
    z,complete = cross_alpha_score(left,right)

    return (x+y+z)%MOD,complete




n = int(input())
arr = [int(i) for i in input().split()]

score,sort_arr = alpha_score(arr,0,n-1)
print(score)
#print("Arr: ",sort_arr)