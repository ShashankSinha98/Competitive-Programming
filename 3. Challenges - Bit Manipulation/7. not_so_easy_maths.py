primes = [2,3,5,7,11,13,17,19]

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
    for i in range(1,1<<n):
        res.append(filter_chars(i,arr))
    
    return res

def count_divisible_nos(N,arr):

    subsets = generate_subsets(arr)
    res = 0
    
    for i in subsets:
        deno = 1

        for j in i:
            deno*=j
        
        sub_res = N//deno

        if len(i)&1==0:
            res-=sub_res
        else:
            res+=sub_res
   
    return res



n = int(input())
queries = []

for i in range(n):
    queries.append(int(input()))

res = []

for i in queries:
    res.append(count_divisible_nos(i,primes))

for i in res:
    print(i)