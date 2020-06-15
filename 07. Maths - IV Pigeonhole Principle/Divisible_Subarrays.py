t = int(input())

while(t!=0):
    t-=1
    n = int(input())
    a = [int(i) for i in input().split()]

    cumm_sum = []
    
    curr_sum = 0
    for i in a:
        curr_sum+=i
        cumm_sum.append((curr_sum+n) % n)

    #print(cumm_sum)

    count_arr = [0 for i in range(n)]
    
    #count_arr[0] = 1 # bcz of null subarr in beginning

    for i in cumm_sum:
        count_arr[i]+=1

    #print(count_arr)

    res = 0
    if count_arr[0]>=1:
        res+=count_arr[0]

    for i in count_arr:
        res += (((i)*(i-1))//2)

    print(res)


