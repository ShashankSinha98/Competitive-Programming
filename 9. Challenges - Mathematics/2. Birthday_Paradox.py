p = float(input())

def compute(min_percent):

    if min_percent==1.0:
        return 366

    persons=0

    deno = 365
    num = 365
    res=num/deno

    while(res>=(1-min_percent)):
        res = res*((num-persons)/deno)
        persons+=1
        
    return persons

print(compute(p))
    