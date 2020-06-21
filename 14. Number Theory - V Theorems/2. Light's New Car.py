# Accepted on hackerblocks 
# Problem link - https://hack.codingblocks.com/app/practice/1/52/problem

MOD = 10**9 + 7
t = int(input())


def StringToInt(s,MOD):
    res = 0
    for i in s:
        res = ((res*10)%MOD + int(i))%MOD

    return res%MOD

def Power(x,y):

    if y==0:
        return 1

    small_ans = Power(x,y//2) 
    small_ans = (small_ans*small_ans)%MOD
    if y&1 == 0:
        return (small_ans)%MOD
    else:
        return (x * small_ans)%MOD
    


while(t!=0):
    t-=1
    A,B = [i for i in input().split()]
    

    X = StringToInt(A,MOD)
    Y = StringToInt(B,MOD-1)

    ans = Power(X,Y)%MOD

    print(ans)