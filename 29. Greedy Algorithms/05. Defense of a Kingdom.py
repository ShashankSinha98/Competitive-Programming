import sys

t = int(input())

while t!=0:
    t-=1

    
    w,h,n = [int(i) for i in input().split()]

    x_coord = [0]
    y_coord = [0]

    while n!=0:
        n-=1
        
        x,y = [int(i) for i in input().split()]
        
        x_coord.append(x)
        y_coord.append(y)

    x_coord.append(w+1)
    y_coord.append(h+1)
    x_coord.sort()
    y_coord.sort()


    x_max = -sys.maxsize
    y_max = -sys.maxsize

    for i in range(1,len(x_coord)):
        temp1 = x_coord[i]-x_coord[i-1]-1
        x_max = max(x_max,temp1)

        temp2 = y_coord[i]-y_coord[i-1]-1
        y_max = max(y_max,temp2)


    print(x_max*y_max)






