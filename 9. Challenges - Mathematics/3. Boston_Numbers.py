import math

n = int(input())

digit_sum = 0
temp = n
while temp!=0:
    rem = int(temp%10)
    digit_sum += rem
    temp = temp//10

factors_sum = 0

temp = n
while(temp%2==0):
    factors_sum+=2
    temp = temp//2
    
for i in range(3,int(math.sqrt(n))+1,2):

    if temp%i==0:
        while temp%i==0:
            temp2 = i
            while temp2 > 0:
                print(temp2 % 10)
                factors_sum = factors_sum + int(temp2 % 10)
                temp2 = temp2 // 10
            temp = temp//i

    if temp==1:
        break

if temp > 1:
    while(temp>=1):
        factors_sum = factors_sum + int(temp%10)
        temp = temp//10

if digit_sum == factors_sum:
    print("1")
else:
    print("0")

