def do_update_range(tree,st,end,qs,qe,inc,index):
    
    # Out of Bound
    if (qe<st or qs>end):
        return

    if(st == end):
        tree[index]+=inc
        return

    mid = (st+end)//2

    do_update_range(tree,st,mid,qs,qe,inc,2*index)
    do_update_range(tree,mid+1,end,qs,qe,inc,2*index+1)

    tree[index] = min(tree[2*index],tree[2*index+1])




def update_range(tree,qs,qe,inc,n):
    do_update_range(tree,0,n-1,qs,qe,inc,1)