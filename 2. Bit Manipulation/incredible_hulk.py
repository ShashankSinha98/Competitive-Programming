def count_set_bits_optimised(N):
    ans = 0
    while(N!=0):
        N = N & (N-1)
        ans+=1
    return ans

t = int(input())

for i in range(t):
	print(count_set_bits_optimised(int(input())))