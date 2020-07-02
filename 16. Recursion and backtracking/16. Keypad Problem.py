keypad = ["","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"]

def generate_names(arr,out,i):

    if i==len(arr) or len(out)==len(arr):
        print(out)
        return

    
    
    num = arr[i]
    if num == 0 or num==1: # For cases having "" string in keypad
        generate_names(arr,out,i+1)
    else :
        word = keypad[num]
        for j in word:
            generate_names(arr,out+[j],i+1)


arr = [1,1,2,3]
#arr = [6,6,6]
generate_names(arr,[],0)


    