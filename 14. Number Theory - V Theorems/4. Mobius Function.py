def Calculate_Mobius(N):
    arr = [1 for i in range(N+1)]
    prime_count = [0 for i in range(N+1)]

    mobius_value = [0 for i in range(N+1)]
    for i in range(2,N+1):
        if prime_count[i]==0:
            for j in range(i,N+1,i):
                prime_count[j]+=1
                arr[j] = arr[j] * i

    for i in range(1, N+1):
        if arr[i] == i:
            if (prime_count[i] & 1) == 0:
                mobius_value[i] = 1
            else:
                mobius_value[i] = -1
        else:
            mobius_value[i] = 0

    return mobius_value


print(Calculate_Mobius(30))


