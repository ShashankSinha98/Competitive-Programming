import sys
class Node:

    data : int
    childrens : dict
    terminal : bool
    count : int

    def __init__(self,data):
        self.data = data
        self.terminal = False
        self.childrens = {}
        self.count = 1

class Trie:

    root : Node
    size : int

    def __init__(self):
        self.root = Node("\0")
        self.size = 0


    def addWord(self,word):
        temp = self.root

        for ch in word:

            if ch in temp.childrens:
                temp = temp.childrens[ch]
                temp.count+=1

            else:
                newNode = Node(ch)
                temp.childrens[ch] = newNode
                temp = newNode
        
        temp.terminal = True



    def findWord(self,word : str) -> bool:
        temp = self.root

        for ch in word:

            if ch not in temp.childrens:
                return False
            else:
                temp = temp.childrens[ch]
        
        return temp.terminal



    def unique_prefix(self,words : []) -> []:

        res = []
        self.root.count = -sys.maxsize

        for word in words:
            pref = ""
            temp = self.root

            for ch in word:

                if  temp.count==1:
                    res.append(pref)
                    break
                else:
                    pref += ch
                    temp = temp.childrens[ch]
            
            if pref==word and temp.count==1:
                res.append(pref)

        return res


words = ["zebra", "dog", "duck", "dove","zebras"]
trie = Trie()

for word in words:
    trie.addWord(word)

ans = trie.unique_prefix(words)
print(ans)






