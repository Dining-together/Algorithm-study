n=int(input())
coins=sorted(list(map(int,input().split())))

presum=0
for i in range (len(coins)):
    if(coins[i]>presum+1):
        break
    else:
        presum+=coins[i]

print(presum+1)