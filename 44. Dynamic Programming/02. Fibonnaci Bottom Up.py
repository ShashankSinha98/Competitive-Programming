LIM = 10**3
arr = [0 for i in range(LIM)]

def Fibb(num):
    global arr

    arr[1] = 1

    for i in range(2,num+1):
        arr[i] = arr[i-1]+arr[i-2]

    return arr[num]



n = int(input())
print(Fibb(n))
