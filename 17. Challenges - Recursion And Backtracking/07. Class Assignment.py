def print_strings(n,i,j,out):

    if len(out)==n:
        print(out)
        return

    if len(out)==0 or out[-1]=='a':
        print_strings(n,i+1,j,out+"a")
        print_strings(n,i,j+1,out+"b")
    else:
        print_strings(n,i+1,j,out+"a")


LIM = 30
sieve = [[0]*2 for i in range(LIM)]
sieve[1][0] = sieve[1][1] = 1
for j in range(2,LIM):
    sieve[j][0] = sieve[j-1][0] + sieve[j-1][1]
    sieve[j][1] = sieve[j-1][0]

t = int(input())
i = 0
while i!=t:
    i+=1
    n = int(input())

    print("#%d : %d"%(i,sieve[n+1][0]))

#print_strings(25,0,0,"")