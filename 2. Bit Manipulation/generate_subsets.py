def filter_chars(n,str):

    res=""
    j=0
    while(n!=0):
        last_bit = n & 1

        if last_bit == 1:
            res+=str[j]
        j+=1
        n=n>>1
    return res

def generate_subsets(string):

    n = len(string)
    res = ""
    for i in range(1<<n):
        res+=filter_chars(i,string)+",   "
    
    return res

print(generate_subsets("abcd"))

        
