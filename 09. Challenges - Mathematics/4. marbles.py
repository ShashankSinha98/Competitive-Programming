# Accepted on Code chef :D
t = int(input())

def combination(a,b):
    
    if a==b or b==0:
        return 1
    
    if b==1:
        return a

    ans = 1

    if b>a-b:
        b = a-b

    for i in range(0,b):
        ans *= ((a-i)/(i+1))
        
    return round(ans)

while(t!=0):
    t-=1
    n,k = [int(i) for i in input().split()]

    print(combination(n-1,k-1))