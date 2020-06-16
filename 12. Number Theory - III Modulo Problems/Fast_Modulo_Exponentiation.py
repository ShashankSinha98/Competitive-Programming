def Fast_Exp(a,b,m):

    res = 1
    while b!=0:
        
        if b&1==1:
            res=(res*a)%m

        b = b>>1
        a=(a*a)%m

    return res 
  
print(Fast_Exp(5,3,100))   

