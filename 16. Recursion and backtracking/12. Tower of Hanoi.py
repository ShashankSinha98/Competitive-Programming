def TowerOfHanoi(n,src,dest,helper):

    # Base case
    if n==0:
        return

    # Moving n-1 disks from src to helper using dest
    TowerOfHanoi(n-1,src,helper,dest)
    # Moving nth disk from src to dest directly 
    print("Move",n,"disk from",src,"to",dest)
    # Moving n-1 disks from helper to dest using src
    TowerOfHanoi(n-1,helper,dest,src)


n = int(input())

TowerOfHanoi(n,'A','C','B')