LIM =10**5+1

sum_arr = [0 for i in range(LIM)]

for i in range(1,LIM):
    for j in range(i,LIM,i):
        if i&1==0:
            sum_arr[j]+=i
        else:
            sum_arr[j]-=i

t = int(input())


while t!=0:
    t-=1
    n = int(input())
    print(sum_arr[n])
