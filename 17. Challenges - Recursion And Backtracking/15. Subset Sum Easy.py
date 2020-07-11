
def generate_subseq(arr,n,i,out):
    global res

    if i==n:
        if len(out)!=0 and sum(out) == 0:
            #print(out)
            res = True
        return

    if len(out)!=0 and sum(out)==0:
        #print(out)
        res = True
        return 
            

    generate_subseq(arr,n,i+1,out)
    out = out + [arr[i]]
    generate_subseq(arr,n,i+1,out)





t = int(input())

while t!=0:
    t-=1
    n = int(input())
    arr = [int(i) for i in input().split()]
    res = False

    generate_subseq(arr,n,0,[])
    if res:
        print("Yes")
    else:
        print("No")