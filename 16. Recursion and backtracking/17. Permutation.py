def permutation(txt,idx):

    if idx==len(txt):
        print(txt)
        return

    for i in range(idx,len(txt)):
        txt[i],txt[idx] = txt[idx],txt[i]
        permutation(txt,idx+1)
        txt[i],txt[idx] = txt[idx],txt[i]


permutation(["a","b","c"],0)