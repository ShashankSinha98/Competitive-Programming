LEN_LIM = 500000
LIM = 10000000

primes = []
primes.append(2)

prime_sieve = [1 for i in range(LIM+1)]
prime_sieve[0] = prime_sieve[1] = 0
for i in range(4,LIM+1,2):
    prime_sieve[i] = 0

for i in range(3,LIM+1):
    if prime_sieve[i] == 1:
        primes.append(i)
        if len(primes) == LEN_LIM:
            break

        for j in range(i*i,LIM+1,2*i):
            prime_sieve[j] = 0

n = int(input())
print(primes[n-1])