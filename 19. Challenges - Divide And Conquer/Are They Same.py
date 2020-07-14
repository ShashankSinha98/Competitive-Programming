def areEqual(a,b):

    if a==b:
        return True

    a_len = len(a)
    b_len = len(b)

    if a_len != b_len or a_len%2 != 0 or b_len%2 != 0:
        return False


    a_mid = a_len//2
    b_mid = b_len//2

    a1 = a[0:a_mid]
    a2 = a[a_mid:]

    b1 = b[0:b_mid]
    b2 = b[b_mid:]

    return (areEqual(a1,b1) and areEqual(a2,b2) or areEqual(a1,b2) and areEqual(a2,b1))



t = int(input())

while t!=0:
    t-=1

    a = input()
    b = input()

    ans = areEqual(a,b)
    res = "YES" if ans else "NO"
    print(res)