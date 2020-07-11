resset = set()

def print_permutations(str_arr,n,i,str_inp):
    
    if i==n:
        #print(str_inp)
        temp = ""
        for k in str_arr:
            temp+=k
        if temp > str_inp:
            resset.add(temp)
        return
    

    for j in range(i,n):
        str_arr[i],str_arr[j] = str_arr[j],str_arr[i]
        print_permutations(str_arr,n,i+1,str_inp)
        str_arr[i],str_arr[j] = str_arr[j],str_arr[i]


        






str_inp = input()
str_arr = [i for i in str_inp]
print_permutations(str_arr,len(str_inp),0,str_inp)
res = list(resset)

res.sort()
for i in res:
    print(i)

