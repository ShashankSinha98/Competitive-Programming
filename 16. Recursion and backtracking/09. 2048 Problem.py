word_arr = ["zero ","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "]

res = ""

# Top Down
def numToWord(num):
    global res

    if num==0:
        return

    w = word_arr[num%10]

    res = w + res

    numToWord(num//10)

def numToWordBottomUp(num):

    if num==0:
        return

    numToWordBottomUp(num//10)
    print(word_arr[num%10],end=" ")

numToWordBottomUp(1023)




numToWord(2048)
print()
print(res)

