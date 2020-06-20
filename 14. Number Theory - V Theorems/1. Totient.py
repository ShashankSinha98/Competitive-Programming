import numpy as np
LIM = 10**5

prime_sieve = [0 for i in range(LIM+1)]

for i in range(2,LIM+1):
    if prime_sieve[i] == 0:
        for j in range(i, LIM+1,i):
            if prime_sieve[j]==0:
                prime_sieve[j] = i

prime_sieve[1] = prime_sieve[0] = 1

N = int(input())
p = N
primes = []
while p!=1:
    x = prime_sieve[p]
    primes.append(x)
    p //= x

#print(primes)

unique_primes = np.unique(primes)

res = N
for i in unique_primes:
    res *= (1-1/i)

print(int(round(res)))


