min_num,max_num=1e9,-1e9

n=int(input())
A=list(map(int,input().split()))
oper=list(map(int,input().split()))

def dfs(idx,value,plus,minus,multiple,divide):
    if(idx==n):
        global min_num,max_num
        min_num=min(min_num,value)
        max_num=max(max_num,value)
        return
    for i in range(4):
        if(i==0 and oper[i]>=plus+1):
            dfs(idx+1,value+A[idx],plus+1,minus,multiple,divide)
        elif(i==1 and oper[i]>=minus+1):
            dfs(idx+1,value-A[idx],plus,minus+1,multiple,divide)
        elif(i==2 and oper[i]>=multiple+1):
            dfs(idx+1,value*A[idx],plus,minus,multiple+1,divide)
        elif(i==3 and oper[i]>=divide+1):
            dfs(idx+1,int(value/A[idx]),plus,minus,multiple,divide+1)

dfs(1,A[0],0,0,0,0)
print(max_num)
print(min_num)