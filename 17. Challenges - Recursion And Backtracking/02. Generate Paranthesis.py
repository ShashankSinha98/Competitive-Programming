def generate_paranthesis(n,i,j,out):

    if j == n:
        print(out)
        return


    if i > j:
        generate_paranthesis(n,i,j+1,out+')')

    if i < n:
        generate_paranthesis(n,i+1,j,out+'(')

    


n = int(input())
generate_paranthesis(n,0,0,"")

