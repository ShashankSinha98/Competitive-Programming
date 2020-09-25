n,d = [int(i) for i in input().split()]

chops = []

for i in range(n):
    inp = int(input())
    chops.append(inp)

chops.sort()

cnt = 0
i = 0
while i+1!=n:
    if chops[i+1]-chops[i]<=d:
        cnt+=1
        i+=2
    else:
        i+=1

print(cnt)

