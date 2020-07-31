import sys

def build_tree(tree,arr,ss,se,index):

    if ss==se:
        tree[index] = arr[ss]
        return
    
    mid = (ss+se)//2
    build_tree(tree,arr,ss,mid,2*index)
    build_tree(tree,arr,mid+1,se,2*index+1)
    tree[index] = tree[2*index]+tree[2*index+1]


def lazy_update(tree,arr,ss,se,qs,qe,inc,index):
    # resolve lazy value if exist
    if lazy[index]!=0:
        tree[index] = tree[index]+ (se-ss+1)*lazy[index]

        # check if child exists, i.e it is not leaf node
        if ss!=se:
            lazy[2*index]+=lazy[index]
            lazy[2*index+1]+=lazy[index]
        
        lazy[index] = 0

    # No Overlap
    if se<qs or qe<ss:
        return 
    
    # complete overlap case
    if ss>=qs and qe>=se:
        tree[index]= tree[index]+ (se-ss+1)*inc

        if ss!=se:
            lazy[2*index]+=inc
            lazy[2*index+1]+=inc
        return

    # Partial Overlap
    mid = (ss+se)//2

    lazy_update(tree,arr,ss,mid,qs,qe,inc,2*index)
    lazy_update(tree,arr,mid+1,se,qs,qe,inc,2*index+1)

    tree[index] = tree[2*index]+tree[2*index+1]


def lazy_query(tree,arr,ss,se,qs,qe,index):
    # resolve lazy value if exist
    if lazy[index]!=0:
        tree[index] = tree[index]+ (se-ss+1)*lazy[index]

        # check if child exists, i.e it is not leaf node
        if ss!=se:
            lazy[2*index]+=lazy[index]
            lazy[2*index+1]+=lazy[index]
        
        lazy[index] = 0

        # No Overlap
    if ss>qe or se<qs:
        return 0

    # Complete Overlap
    if qs<=ss and qe>=se:
        return tree[index]

    # partial Overlap
    mid = (ss+se)//2
    left = lazy_query(tree,arr,ss,mid,qs,qe,2*index)
    right = lazy_query(tree,arr,mid+1,se,qs,qe,2*index+1)

    return left+right



arr = [1, 3, 2, -5, 6, 4]
n = len(arr)
tree = [0 for i in range(4*n+1)]
lazy = [0 for i in range(4*n+1)]
build_tree(tree,arr,0,n-1,1)
#print(tree)
lazy_update(tree,arr,0,n-1,1,4,10,1)
#print(tree)
print(lazy_query(tree,arr,0,n-1,1,3,1))