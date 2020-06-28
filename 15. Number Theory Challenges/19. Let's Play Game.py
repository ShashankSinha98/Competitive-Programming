# Accepted
# Hint- for any no n, n! factors a1^p1 + a2^p2+...+ak^pk, here a1,a2,...,ak will always be <=n
# we need to calculate prime nos in range 1 to n. k = no's counted
# ans = 2**(k-1), why? if any no has k unique factors (pow not included), then we need to place them 
# in 2 pos, either in num or deno, so each no has 2 prob and thus 2^k total possibility.
#  but as we want num<deno. therefore only 2^(k-1) ways. (as in half case num<den), can be seen using ex of 5
# easily.

LIM=500
sieve = [1 for i in range(LIM+1)]

sieve[0] = sieve[1] = 0
for i in range(4,LIM+1,2):
    sieve[i] = 0

for i in range(2,LIM+1):
    if sieve[i]==1:
        for j in range(i*i,LIM+1,2*i):
            sieve[j] = 0

cumm_sieve = [0 for i in range(LIM+1)]

s = 0
for i in range(LIM+1):
    s+=sieve[i]
    cumm_sieve[i] = s

#print(sieve)
#print(cumm_sieve)

n = int(input())
res = 0
for i in range(2,n+1):
    if cumm_sieve[i]!=0:
        res += 2**(cumm_sieve[i]-1)

print(res)