# accepted on codechef 
def binary_search(a,x):

    left = 0
    right = len(a)-1

    while(left<=right):
        mid = (left+right)//2

        if a[mid] == x:
            return True
        
        elif a[mid] > x:
            right = mid-1
        else:
            left = mid+1

    return False

def search(a,x,i,j,k):

    n = len(a)
    for ni in range(n):

        if ni==i or ni==j or ni==k:
            continue

        elif a[ni] == x:
            return True

            
    return False


def compute(a):
    n = len(a)
    res = "No"
    for i in range(n):
        for j in range(i+1,n):
            for k in range(j+1,n):
                temp = (a[i]^a[j]^a[k])
                #print(temp)

                if search(a,temp,i,j,k) == True:
                    res = "Yes"
                    #print(res)
                    return res
    return res



n = int(input())
a = [int(i) for i in input().split()]

if n >= 130:
    print("Yes")
else:
    a.sort()
    #print(a)
    print(compute(a))







