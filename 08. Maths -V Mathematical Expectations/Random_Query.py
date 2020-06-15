# Accepted on Hacker blocks and on Codeforces

lim = 10**7
last_occ = [ 0 for i in range(lim)]

n = int(input())
ans = [0 for i in range(n+1)]

arr = [int(i) for i in input().split()]
arr.insert(0,0 )
#print("arr",arr)

for i in range(1,n+1):
    ans[i] = ans[i-1] + (i-last_occ[arr[i]])
    last_occ[arr[i]] = i

#print("ans",ans)
total_sum = sum(ans)

ans = round((2*(total_sum-n)+n)/n**2,6)
#print(ans)
print(format(ans,'.6f'))

