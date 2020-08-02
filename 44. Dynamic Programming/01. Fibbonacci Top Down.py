LIM = 10**6
arr = [0 for i in range(LIM)]

def Fibb(num):
    global arr

    if num==0 or num==1:
        return num

    if arr[num]!=0:
        return arr[num]

    ans = Fibb(num-1)+Fibb(num-2)
    arr[num] = ans
    return ans


n = int(input())
print(Fibb(n))