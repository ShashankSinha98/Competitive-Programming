#import segment_tree 

def do_point_update(tree,st,end,updt_idx,inc,index):

    if (updt_idx<st or updt_idx>end):
        return 

    if(st==end==updt_idx):
        tree[index] = tree[index]+inc
        return 


    mid = (st+end)//2

    do_point_update(tree,st,mid,updt_idx,inc,2*index)
    do_point_update(tree,mid+1,end,updt_idx,inc,2*index+1)

    tree[index] = min(tree[2*index],tree[2*index+1])

    return

def point_update(tree,updt_idx,inc,n):
    do_point_update(tree,0,n-1,updt_idx,inc,1)

    


#arr = [int(i) for i in input().split()]
#n = len(arr)
#tree = build(arr)
#updt_index,inc = [int(i) for i in input().split()]
#point_update(tree,updt_index,inc,n)


