PRIME = 3


def cal_hash(inp_str):
    res = 0
    n = len(inp_str)

    for  i in range(n):
        res += (ord(inp_str[i])*(PRIME**i))
    
    return res

def rolling_hash(inp_str,old_hash,i,m):

    old_hash -= ord(inp_str[i])
    old_hash = old_hash//PRIME
    old_hash += (ord(inp_str[i+m-1])*(PRIME**(m-1)))

    return old_hash


def count_occurence(inp_str, pattern):

    n = len(inp_str)
    m = len(pattern)

    pattern_hash = cal_hash(pattern)
    input_hash = cal_hash(pattern[0:m])

    cnt = 0
    if pattern_hash == input_hash and check(inp_str,pattern,0):
        cnt+=1

    for idx in range(1,n-m+1):
        input_hash = rolling_hash(inp_str,input_hash,idx,m)

        if input_hash == pattern_hash and check(inp_str,pattern,idx):
            cnt+=1

    return cnt



def check(inp_str,pattern,idx):
    m = len(pattern)
    for i in range(m):
        if inp_str[idx+i] != pattern[i]:
            return False
    return True


inp_str = input()
pattern = input()

print(count_occurence(inp_str,pattern))