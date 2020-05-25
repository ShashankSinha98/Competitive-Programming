n = int(input())

queries = []
for i in range(n):
    queries.append([int(i) for i in input().split()])

def count_set_bits(N):
    ans=0

    while(N!=0):
        N = N & (N-1)
        ans+=1
    return ans

for i in range(n):
    a = queries[i][0]
    b = queries[i][1]

    ans = 0

    for j in range(a,b+1):
        ans+=count_set_bits(j)
    print(ans)
