# @Link - https://hack.codingblocks.com/app/practice/1/137/problem
# Accepted on Hacker Blocks

import math
MAX_VALUE = 10**8


t = int(input())


while(t!=0):
    t-=1

    n,k = [int(i) for i in input().split()]

    ans = MAX_VALUE

    occ = 0
    for i in range(2,int(math.sqrt(k))):
       
        if k%i==0:
            occ = 0
            while k%i==0:
                occ+=1
                k//=i

            cnt = 0
            p = i
            while p<=n:
                cnt+=n//p
                p*=i

            ans = min(ans,cnt//occ)

    if k>1:
        cnt = 0
        p = k
        while p<=n:
            cnt+=n//p
            p*=k
        ans = min(ans,cnt)


    if ans == MAX_VALUE:
        ans = 0

    print(ans)

