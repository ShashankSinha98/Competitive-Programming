
from operator import itemgetter
res = set()
def solve(arr,i,k,out):

    if i == len(arr):
        if sum(out)==k:
            #print(out)
            s = ""
            for j in out:
                s = s + str(j)+" "
            res.add(s)
        return

    if sum(out) > k:
        return

    solve(arr,i+1,k,out)
    out = out + [arr[i]]
    solve(arr,i+1,k,out)




n = int(input())
arr = [int(i) for i in input().split()]
arr.sort()
k = int(input())
solve(arr,0,k,[])
resList = list(res)
resList.sort()
#print(resList)
finalList = []
for i in resList:
    temp = []
    for j in i.split():
        temp.append(int(j))

    finalList.append(temp)

finalList.sort()
for i in finalList:
    for j in i:
        print(j, end=" ")
    print()



