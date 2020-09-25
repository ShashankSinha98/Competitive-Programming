

def no_of_coins(amt,coins):

    cnt = 0
    while amt!=0:
        cnt+=1
        for i in range(len(coins)-1,-1,-1):
            if amt-coins[i]>=0:
                amt = amt - coins[i]
                break

    return cnt



coins = [1,2,5,10,20,50,100,500,2000]
amt = int(input())
print(no_of_coins(amt,coins))