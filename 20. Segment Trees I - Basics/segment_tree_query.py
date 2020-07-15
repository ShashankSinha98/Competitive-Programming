#import segment_tree
import sys

def do_query(tree,qs,qe,st,end,index):

    # Complete overlap
    if(qs<=st and qe>=end):
        return tree[index]

    
    # No Overlap
    if(qs<st and qe<st) or (qs>end and qe>end):
        return sys.maxsize

    mid = (st+end)//2

    left = do_query(tree,qs,qe,st,mid,2*index)
    right = do_query(tree,qs,qe,mid+1,end,2*index+1)

    return min(left,right)

def min_query(tree,qs,qe,n):
    return do_query(tree,qs,qe,0,n-1,1)


#arr = [int(i) for i in input().split()]
#n = len(arr)
#tree = build(arr)
#qs,qe = [int(i) for i in input().split()]
#print(min_query(tree,qs,qe,n))


