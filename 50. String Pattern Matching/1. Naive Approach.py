def count_occ(inp_str,pattern):

    cnt = 0

    n = len(inp_str)
    m = len(pattern)

    j = 0
    for i in range(n-m+1):

        if inp_str[i] == pattern[0]:
            temp = i
            while j < m:

                if inp_str[temp] == pattern[j]:
                    temp+=1
                    j+=1
                else:
                    j = 0
                    break

                if j==m:
                    j = 0
                    cnt+=1
                    break

    return cnt
                

inp_str = input()
pattern = input()

print(count_occ(inp_str,pattern))