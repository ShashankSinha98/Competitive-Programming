class Node:

    data : int
    childrens : dict
    terminal : bool

    def __init__(self,data):
        self.data = data
        self.terminal = False
        self.childrens = {}

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
            else:
                newNode = Node(ch)
                temp.childrens[ch] = newNode
                temp = newNode
        
        temp.terminal = True

    def findWord(self,word) -> bool:

        temp = self.root

        for ch in word:

            if ch not in temp.childrens:
                return False
            else:
                temp = temp.childrens[ch]
        
        return temp.terminal


#words = ["a","hello","not","news","apple"]
#trie = Trie()

#for w in words:
    #trie.addWord(w)

#myWord = "appl"
#print(trie.findWord(myWord))


