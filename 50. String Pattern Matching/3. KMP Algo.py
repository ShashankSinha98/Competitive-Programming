#   input_str = input()
#   pattern = input()


def build_helper_arr(pattern):

    m = len(pattern)
    arr = [0] * m

    j = 0
    i = 1
    while (i<m):

        if pattern[i]==pattern[j]:
            arr[i] = j+1
            i+=1
            j+=1

        elif pattern[i] != pattern[j]:
            if j==0:
                arr[i] = 0
                i+=1
            else:
             j = arr[j-1]

    return arr

def search(input_str, pattern):

    n,m = len(input_str),len(pattern)

    i=j=0
    helper = build_helper_arr(pattern)

    while(i<n):
        #print(i,j)
        
        if input_str[i]==pattern[j]:
            if j==m-1:
                print("Pattern found at ",i-j)
                j = helper[j-1]
            else:
                i+=1
                j+=1
            
        elif input_str[i] != pattern[j]:
            if j==0:
                i+=1
            else:
                j = helper[j-1]

    #if j==m:
     #   print("Pattern found at ",i-j+1)

input_str = "THIS IS A TEST TEXT"
pattern = "TEST"

print(build_helper_arr("qgqbqgqlqjqgvqgqbqwqgdqgqbqgqlqjqgvqgqbqqqgqbqgqlqjqgvqgqbqwqgdqgqbqgqlqjqgvqgqbbqgqbqgqlqjqgvqgqbqwqgdqgqbqgqlqjqgvqgqbqqqgqbqgqlqjqgvqgqbqwqgdqgqbqiqgqbqgqlqjqgvqgqbqwqgdqgqbqgqlqjqgvqgqbqqqgqbqgqlqjqgvqgqbqwqgdqgqbqgqlqjqgvqgqbbqgqbqgqlqjqgvqgqbqwqgdqgqbqgqlqjqgvqgqmqgqbqgqlqjqgvqgqbqwqgdqgqbqgqlqjqgvqgqbqqqgqbqgqlqjqgvqgqbqwqgdqgqbqgtqgqbqgqlqjqgvqgqbqwqgdqgqbqgqlqjqgvqgqbqqqgqbqgqlqjqgvqgq"))
search(input_str,pattern)        







