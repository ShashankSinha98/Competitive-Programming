import sys
n = int(input())
arr = []
xor = 0

for i in range(n):
    num = int(input())
    arr.append(num)
    xor ^= num

max_xor = -1 * sys.maxsize

for i in arr:
    if xor^i > max_xor:
        max_xor = xor^i

print(max_xor)