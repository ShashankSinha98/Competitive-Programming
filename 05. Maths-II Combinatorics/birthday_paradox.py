def no_of_persons(min_percent):

    if min_percent==1.0:
        return 366
    
    count=0
    prob=1.0

    while(prob>=(1-min_percent)):
        prob *= (365-count)/365
        count+=1
        
    
    return count

prob = float(input())
print(no_of_persons(prob))
