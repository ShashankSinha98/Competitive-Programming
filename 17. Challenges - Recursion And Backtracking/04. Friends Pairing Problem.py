LIM = 31
sieve = [0 for i in range(LIM)]
sieve[1] = 1
sieve[2] = 2

for i in range(3,LIM):
    sieve[i] = sieve[i-1] + ( (i-1) * sieve[i-2] )

t = int(input())

while t!=0:
    t-=1
    n = int(input())
    print(sieve[n])

