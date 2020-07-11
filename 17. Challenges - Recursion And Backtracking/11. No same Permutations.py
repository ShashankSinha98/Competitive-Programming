ansset  = set()
def print_unique_permutation(inp,i,n):
    global ansset

    if i == n:
        res = ""
        for j in inp:
            res=res + j+" "
        ansset.add(res)

        return


    for j in range(i,n):
        if i==j or inp[i] != inp[j]:
            
            inp[i],inp[j] = inp[j],inp[i]
            print_unique_permutation(inp,i+1,n)
            inp[i],inp[j] = inp[j],inp[i]

n = int(input())        
inp = [i for i in input().split()]
inp.sort()
print_unique_permutation(inp,0,n)
ans = [i for i in ansset]
ans.sort()
for j in ans:
    print(j)