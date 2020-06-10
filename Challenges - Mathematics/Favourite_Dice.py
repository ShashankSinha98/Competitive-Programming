# Accepted on SPOJ
t = int(input())

while(t!=0):
    t-=1
    n = int(input())

    ans = 0
    for i in range(1,n+1):
        ans+=1/i


    print(round(ans*n,2))