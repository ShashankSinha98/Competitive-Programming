ansset  = set()
def print_unique_permutation(inp,i,out):
    global ansset

    if i == len(inp):
        res = ""
        for j in inp:
            res+=j
        ansset.add(res)

        return


    for j in range(i,len(inp)):
        if i==j or inp[i] != inp[j]:
            
            inp[i],inp[j] = inp[j],inp[i]
            print_unique_permutation(inp,i+1,out)
            inp[i],inp[j] = inp[j],inp[i]
        
inp = [i for i in input()]
inp.sort()
print_unique_permutation(inp,0,"")
ans = [i for i in ansset]
ans.sort()
for j in ans:
    print(j)