# a x b = LCM(a, b) * GCD (a, b)
def GCD(a,b):
    return a if b==0 else GCD(b,a%b)
      
print(GCD(12,20)) 