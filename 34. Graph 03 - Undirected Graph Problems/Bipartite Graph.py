def is_cycle(node,visited,parent,flip):
    global arr,n

    visited[node] = flip
    flip = (flip+1)%2
    
    subarr = arr[node]
    for c in range(n):
        if subarr[c]==1 and visited[c]==0:
            return is_cycle(c,visited,node,flip)
        elif subarr[c]==1 and c!=parent:
            if visited[c]==visited[node]:
                return False
            
    return True
        



def is_bipartite(arr):
    visited = [0]*len(arr)
    return is_cycle(0,visited,-1,1)



n = 3
arr = [[0, 1, 0],[0, 0, 1], [1, 0, 0]]
print(is_bipartite(arr))