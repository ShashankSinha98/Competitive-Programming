# Not accepted on SPOJ - Wrong Answer

inp_arr = [int(i) for i in input().split()]
N,A,B = inp_arr

sequence = []
for i in range(N):
    sequence.append(int(input()))

sequence.sort()

def filter_chars(n,arr):

    res=[]
    j=0
    while(n!=0):
        last_bit = n & 1

        if last_bit == 1:
            res.append(arr[j])
        j+=1
        n=n>>1
    return res

def generate_subsets(arr):

    n = len(arr)
    res = []
    for i in range(1<<n):
        res.append(filter_chars(i,arr))
        
    return res


def lower_bound_bin_search(arr,k):
    left = 0
    right = len(arr)-1
    res = -1

    while(left<=right):
        mid = ((left+right)//2)
        
        if arr[mid] == k:
            res =  mid
            right = mid-1
        elif k>arr[mid]:
            left = mid+1
        else:
            right = mid-1
    
    if arr[res]==k:
        return res
    else:
        return mid

def upper_bound_bin_search(arr,k):
    left = 0
    right = len(arr)-1
    res = -1

    while(left<=right):
        mid = ((left+right)//2)
        
        if arr[mid] == k:
            res =  mid
            left = mid+1
        elif k>arr[mid]:
            left = mid+1
        else:
            right = mid-1
    
    if arr[res]==k:
        return res
    else:
        return mid



n = len(sequence)
set1 = sequence[0:n//2]
set2 = sequence[n//2:]

subsets1 = generate_subsets(set1)
subsets2 = generate_subsets(set2)
#print(subsets1)
#print(subsets2)
subsets1.remove([])
subsets2.remove([])
#print("After removing")
#print(subsets1)
#print(subsets2)

sum_subsets1 = [sum(i) for i in subsets1]
sum_subsets2 = [sum(i) for i in subsets2]
#sum_subsets1.sort()
sum_subsets2.sort()
#sum_subsets2.remove(0)
#sum_subsets1.remove(0)
count = 0

if A<=0<=B:
    count+=1

for i in sum_subsets1:
    if A<=i<=B:
        count+=1
#print("Count: ",count)
for i in sum_subsets2:
    if A<=i<=B:
        count+=1
#print("Count: ",count)

for i in sum_subsets1:
    lower_bound = A-i
    upper_bound = B-i
    #print("LB:",lower_bound," UB:",upper_bound)
    st_idx = lower_bound_bin_search(sum_subsets2,lower_bound)
    end_idx = upper_bound_bin_search(sum_subsets2,upper_bound)


    if st_idx == end_idx:
        continue
    
    if sum_subsets2[end_idx] > upper_bound:
        end_idx = end_idx - 1
        
    
    sub_count = end_idx - st_idx + 1 
    #print(st_idx,end_idx)
    
    if sub_count > 0:
        count+=sub_count
    #print("Count:",count)


print(count)

#print(sum_subsets1)
#print(sum_subsets2)