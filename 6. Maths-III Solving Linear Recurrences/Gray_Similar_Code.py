# Accepted on Codechef
def compute(a):
    n = len(a)
    res = "No"
    for i in range(n):
        for j in range(i+1,n):
            for k in range(j+1,n):
                for l in range(k+1,n):
                    if (a[i]^a[j]^a[k]^a[l]) == 0:
                        res = "Yes"
                        #print(res)
                        return res
    return res



n = int(input())
a = [int(i) for i in input().split()]

if n >= 130:
    print("Yes")
else:
    print(compute(a))







