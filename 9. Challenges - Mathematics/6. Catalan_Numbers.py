n = int(input())

num = 1
deno = 1

for i in range(n+1,(2*n)+1):
    num*=i

for i in range(1,n+1):
    deno *= i

ans = num//(deno*(n+1))

print(ans)