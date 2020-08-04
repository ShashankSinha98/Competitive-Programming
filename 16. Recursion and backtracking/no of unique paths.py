def solve(m,n):

    if m==0 or n==0:
        return 1

    # Recc case
    return solve(m-1,n) + solve(m,n-1)


m,n = [int(i) for i in input().split()]
print(solve(m-1,n-1))