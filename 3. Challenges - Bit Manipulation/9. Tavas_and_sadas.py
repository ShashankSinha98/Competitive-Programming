# Accepted on Codeforces

n = input()

x = len(n)

small_count = 2*(2**(x-1)-1)

big_count = 1 # counting that no' itself

for i in range(0,x):
    
    if n[i] == '7':
        big_count += 2**(x-i-1)

print(big_count+small_count)