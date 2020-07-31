import sys

def build_tree(tree,arr,ss,se,index):

    if ss==se:
        tree[index] = arr[ss]
        return
    
    mid = (ss+se)//2
    build_tree(tree,arr,ss,mid,2*index)
    build_tree(tree,arr,mid+1,se,2*index+1)
    tree[index] = min(tree[2*index],tree[2*index+1])



arr = [int(i) for i in input().split()]
n = len(arr)
tree = [sys.maxsize for i in range(4*n+1)]
build_tree(tree,arr,0,n-1,1)
print(tree)
