def generateSubseq(arr,subarr,i):

    if i==len(arr):
        print(subarr)
        return
    
    generateSubseq(arr,subarr,i+1)
    subarr = subarr+[arr[i]] 
    generateSubseq(arr,subarr,i+1)

arr = ['a','b','c']
generateSubseq(arr,[],0)