t = int(input())

for i in range(t):
    inp = input().split()
    a,b = inp
    
    pos=0
    res=""
    while pos<len(a):
        if a[pos]!=b[pos]:
            res = res+"1"
        else:
            res = res+"0"
        
        pos+=1

    print(res)
