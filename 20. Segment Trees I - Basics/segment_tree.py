import sys
import segment_tree_query
import segment_tree_point_update
import segment_tree_update_range

def build(arr):
    N = len(arr)
    tree = [sys.maxsize for i in range(4*N+1)]
    build_tree(arr,tree,0,N-1,1)
    return tree


def build_tree(arr,tree,st,end,index):

    if (st==end):
        tree[index] = arr[st]
        return

    mid = (st+end)//2

    build_tree(arr,tree,st,mid,2*index)
    build_tree(arr,tree,mid+1,end,2*index+1)

    tree[index] = min(tree[2*index],tree[2*index+1])
    


arr = [1,3,2,-5,6,4]
n = len(arr)
#print(build(arr))
tree = build(arr)
#updt_index,inc = [int(i) for i in input().split()]
#segment_tree_point_update.point_update(tree,updt_index,inc,n)
segment_tree_update_range.update_range(tree,3,5,10,n)

qs,qe = [int(i) for i in input().split()]
print(segment_tree_query.min_query(tree,qs,qe,n))
