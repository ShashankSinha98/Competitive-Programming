# Accepted on Codechef :D
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

    index_arr = [[] for i in range(n)]
    
    #count_arr[0] = 1 # bcz of null subarr in beginning
    #print(index_arr)

    for i in range(n):
        index_arr[cumm_sum[i]].append(i)

    #print(index_arr)

    if len(index_arr[0])>=1:
        print(index_arr[0][0]+1)
        for i in range(index_arr[0][0]+1):
            print(i+1,end=" ")

    else:
        for i in range(1,n):
            if len(index_arr[i])>1:
                st_idx = index_arr[i][0]
                end_idx = index_arr[i][1]
                
                size = end_idx-st_idx
                print(size)
                for j in range(st_idx+1,end_idx+1):
                    print(j+1,end=" ")
                break


