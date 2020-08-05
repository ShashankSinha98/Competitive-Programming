import sys
# Kadane's Algo
def solve(arr):

    max_so_far = -sys.maxsize
    max_till_ith = 0
    n = len(arr)

    for i in range(n):
        max_till_ith += arr[i]

        if max_till_ith>max_so_far:
            max_so_far = max_till_ith
        if max_till_ith < 0:
            max_till_ith = 0

    return max_so_far
        
arr = [-2, -3, 4, -1, -2, 1, 5, -3]
print(solve(arr))
