class TrieNode:

    left = TrieNode()
    right = TrieNode()

    


class Trie:

    head : TrieNode

    def addData(self, num : int):

        temp = self.head

        for i in range(31,-1,-1):
            curr_bit = (num>>i) & 1

            if curr_bit == 0:
                if temp.left == None:
                    temp.left =  TrieNode()
                
                temp = temp.left
            else:
                if temp.right == None:
                    temp.right = TrieNode()
                
                temp = temp.right   


    def findMaxXorPair(self,n : int):
        curr_xor = 0
        curr = self.head

        for i in range(31,-1,-1):
            curr_bit = (n>>i) & 1    

            if curr_bit == 0:
                if curr.right != None:
                    curr = curr.right
                    curr_xor += int(pow(2,i))
                else:
                    curr = curr.left
            else:
                if curr.left != None:
                    curr = curr.left
                    curr_xor += int(pow(2,i))
                else:
                    curr = curr.right
            
            return curr_xor


arr = [3,10,5,25,2,8]
trie = Trie()

max_xor = 0
for i in arr:
    trie.addData(i)
    x = trie.findMaxXorPair(i)
    max_xor = max(max_xor,x)

print(max_xor)

                         
                
                    