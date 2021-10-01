#boj 13305
n=int(input())
dist_list=list(map(int,input().split()))
price_list=list(map(int,input().split()))
remain_oil,total_cost=0,0

for i in range(len(dist_list)):
    # print(remain_oil,price_list[i],total_cost)
    if(remain_oil>0):
        remain_oil-=dist_list[i]
    else:
        total_cost+=dist_list[i]*price_list[i]
        for j in range(i+1,len(dist_list)):
            if(price_list[j]<price_list[i]):
                break
            else:
                remain_oil+=dist_list[j]
                total_cost+=dist_list[j]*price_list[i]

print(total_cost)