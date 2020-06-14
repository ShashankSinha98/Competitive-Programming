n = 100

def prime_sieve(n):

    arr = [1 for i in range(n+1)]
    arr[0] = 0
    arr[1] = 0
    arr[2] = 1

    for i in range(2*2,n+1,2):
       arr[i] = 0

    for i in range(3,n,2):
        if arr[i] == 1:
            for j in range(i*i,n+1,i):
                arr[j] = 0

    return arr

primes = prime_sieve(n)
for i in range(1,n+1):
    if primes[i]==1:
        print(i,end="   ")

