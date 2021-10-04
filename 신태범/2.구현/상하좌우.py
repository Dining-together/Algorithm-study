n=int(input())
commands=input().split()

dir=[[0,-1],[-1,0],[0,1],[1,0]]

def can_go(point):
    return (point[0]>0 and point[1]>0 and point[0]<=n and point[1]<=n)
def move_point(command,point):
    if(command=='L'):
        result=[dir[0][0]+point[0],dir[0][1]+point[1]]
        if(can_go(result)):
            return result
        return point
    elif(command=='U'):
        result=[dir[1][0]+point[0],dir[1][1]+point[1]]
        if(can_go(result)):
            return result
        return point
    elif(command=='R'):
        result=[dir[2][0]+point[0],dir[2][1]+point[1]]
        if(can_go(result)):
            return result
        return point
    elif(command=='D'):
        result=[dir[3][0]+point[0],dir[3][1]+point[1]]
        if(can_go(result)):
            return result
        return point

position=[1,1]
for i in range(len(commands)):
    position=move_point(commands[i],position)

print(position[0],position[1])