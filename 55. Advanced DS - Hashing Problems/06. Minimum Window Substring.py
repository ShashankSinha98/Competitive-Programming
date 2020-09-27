import sys

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        if len(s)<len(t):
            return ""
        
        t_arr = [0]*256
        s_arr = [0]*256

        for i in t:
            t_arr[ord(i)]+=1
        
        st = 0
        end = 1
        s_arr[ord(s[st:end])]+=1

        minLen = sys.maxsize
        minAns = ""

        while end!=len(s)+1:
            #print("Current-> "+s[st:end])
            # window not found
            if self.match(t_arr,s[st:end]):
                #print("Expanding-> curr: "+s[st:end],end="")
                if end-st<minLen:
                    minLen = end-st
                    minAns = s[st:end]

                # window found !! now cheking if we can shrink or not
                #print("INNSIDE****************************************************")
                #print(s_arr[ord(s[st])],t_arr[ord(s[st])])
                while s_arr[ord(s[st])] > t_arr[ord(s[st])]:
                    #print("Shrinking-> curr: "+s[st:end],end="")
                    s_arr[ord(s[st])]-=1
                    st+=1
                    #print(" now: "+s[st:end])
                    if end-st<minLen:
                        minLen = end-st
                        minAns = s[st:end]
            
            if end<len(s):
                s_arr[ord(s[end])]+=1
        
            end+=1
            #print(" now: "+s[st:end])

        return minAns



            



    def match(self,t_arr,subs):
        #print("Checking Match of: "+subs)
        temp = [0]*256
        for i in subs:
            temp[ord(i)]+=1
        

        for i in range(256):
            if t_arr[i]!=0 and t_arr[i]>temp[i]:
                #print("Not matched for- "+chr(i))
                return False

        return True





S = "cabwefgewcwaefgcf"
T = "cae"

ans = Solution().minWindow(S,T)
print(ans)


