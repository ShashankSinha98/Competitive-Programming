N = int(input())

factors = []

i = 2
while i*i<=N:
    if N%i == 0:
        while N%i == 0:
            factors.append(i)
            N //= i
    i+=1

if N!=1:
    factors.append(N)

print(factors)


