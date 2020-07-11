table = [ " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" ]

def print_soln(n,i,out):

    if i==len(n):
        print(out)
        return


    word = table[int(n[i])]

    #if n[i] == "0":
    #    print_soln(n,i+1,out)
    #else:
    for j in word:
        print_soln(n,i+1,out+j)

n = input()
print_soln(n,0,"")
