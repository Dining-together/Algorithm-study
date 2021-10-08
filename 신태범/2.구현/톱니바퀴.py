def turn_around(num,dir,gears):
    #시계방향
    if(dir==1):
        gears[num].insert(0,gears[num][7])
        gears[num].pop()
    #반시계 방향
    elif(dir==-1):
        gears[num].append(gears[num][0])
        del gears[num][0]
    return gears

def simulate(num,dir,gears):
    diff_12,diff_23,diff_34=gears[0][2]!=gears[1][6],gears[1][2]!=gears[2][6],gears[2][2]!=gears[3][6]
    if num==0:
        one,two=True,diff_12
        three=two and diff_23
        four=three and diff_34
    elif num==1:
        two=True
        one,three=diff_12,diff_23
        four=three and diff_34
    elif num==2:
        three=True
        two,four=diff_23,diff_34
        one=two and diff_12
    elif num==3:
        four=True
        three=diff_34
        two=three and diff_23
        one=two and diff_12

    if(num%2==1):
        dir=-dir

    if(one):
        gears=turn_around(0,dir,gears)
    if(two):
        gears=turn_around(1,-dir,gears)
    if(three):
        gears=turn_around(2,dir,gears)
    if(four):
        gears=turn_around(3,-dir,gears)
   
    return gears
    
gears=[]

for _ in range(4):
    gear=input()
    gears.append([int(gear[i]) for i in range(len(gear))])

k=int(input())

for i in range(k):
    num,dir=map(int,input().split())
    gears=simulate(num-1,dir,gears)

print(gears[0][0]+gears[1][0]*2+gears[2][0]*4+gears[3][0]*8)