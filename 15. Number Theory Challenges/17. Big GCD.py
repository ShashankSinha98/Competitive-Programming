
def GCD(a,b):
    return a if b==0 else GCD(b,a%b)

a,b = [int(i) for i in input().split()]

print(GCD(a,b))