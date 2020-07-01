def Pow1(a,b):
    if b==1:
        return a

    return a * Pow1(a,b-1)


def Pow2(a,b):

    if b==1:
        return a

    small_ans = Pow2(a,b>>1)
    small_ans*=small_ans
    if b&1:
        return a*small_ans
    else:
        return small_ans


print(Pow2(2,10))