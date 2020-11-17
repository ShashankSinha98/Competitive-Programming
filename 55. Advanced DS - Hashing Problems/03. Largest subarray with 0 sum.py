def maxLen(n, arr):
    #Code here
    
    maxDiff = 0
    mydict = {}
    cumm = [0]*(n+1)
    mydict[0] = 0
    
    for i in range(1,n+1):
        cumm[i] = cumm[i-1] + arr[i-1]
        if cumm[i] not in mydict:
            mydict[cumm[i]] = i
        else:
            st = mydict[cumm[i]]
            diff = i-st
            maxDiff = max(maxDiff,diff)
    
    return maxDiff
