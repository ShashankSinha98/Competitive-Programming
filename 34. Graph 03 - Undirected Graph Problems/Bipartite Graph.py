def isBipertite(arr, n):
    # Code here
    for i in range(n):
        ans = check(arr,n,i)
        if not ans:
            return False
    return True
        

def check(arr,n,src):
    
    
    color = [-1]*n
    color[src] = 1
    
    queue = []
    queue.append(src)
    
    while len(queue)!=0:
        
        u = queue.pop()
        
        if arr[u][u]==1:
            return False
            
        for i in range(n):
            
            if arr[u][i]==1 and color[i]==-1:
                color[i] = (color[u]+1)%2
                queue.append(i)
            
            elif arr[u][i]==1 and color[i]==color[u]:
                return False
                
    return True


graph = [[0, 1, 0, 1], 
            [1, 0, 1, 0], 
            [0, 1, 0, 1], 
            [1, 0, 1, 0] 
            ] 

print(isBipertite(graph,4))


