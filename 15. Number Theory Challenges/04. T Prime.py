import math

LIM = 10**6

n = int(input())
arr = [int(i) for i in input().split()]

primes = []
primes.append(2)
prime_sieve = [1 for i in range(LIM+1)]
prime_sieve[0] = prime_sieve[1] = 0
for i in range(4,LIM+1,2):
    prime_sieve[i]=0

for i in range(3,LIM+1):
    if prime_sieve[i]==1:
        primes.append(i)
        for j in range(i*i,LIM+1,2*i):
            prime_sieve[j] = 0


for i in arr:
    if (int(math.sqrt(i))*int(math.sqrt(i))==i and prime_sieve[int(math.sqrt(i))]==1):
        print("YES")
    else:
        print("NO")