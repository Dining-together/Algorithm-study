'''
그리디

n,k가 100이하여서 마음대로 구현..
다음 행동을 알고 있는 것을 이용하자.
-> 멀티탭의 개수만큼 씩 다음 행동 살펴보기

반복할 행동
1. 멀티탭이 비어있거나, 해당 전자기기의 멀티탭이 꽂혀있으면 그냥 사용
2. 사용중이지 않고, 비어 있는 멀티탭이 없을경우 다음 n개의 행동에 사용되지 않는 플러그빼기(?)
'''
from sys import _current_frames


n,k=map(int,input().split())
orders=list(map(int,input().split()))

current_count,plug_in,ans=0,[0 for i in range(k+1)],0

for idx in range(len(orders)):
    #이미 꽂혀있으면
    i=orders[idx]
    
    # print(plug_in)
    if(plug_in[i]==1):
        continue
    #비어있는 구멍이 있으면
    if(current_count<n):
        plug_in[i]=1
        current_count+=1
    #비어있는 구멍이 없으면
    else:
        current_using=[]
        for j in range(len(plug_in)):
            if(plug_in[j]==1):
                current_using.append(j)

        #어떤 걸 뺄 것인가
        target=0
        after_using=[]
        #다음 명렁을 살펴본다
        after_using.append(i)
        for j in range(idx+1,len(orders)):
            # 현재 넣을 명령이거나 이미 포함한 명령은 제외
            if orders[j] in after_using:
                continue
            else:
                after_using.append(orders[j])

        # 다음 명령 정보를 이용하여 어떤걸 뺄 것인가?
        # -> 이후에 사용되지 않는것, 사용되는 것 중에 가장 늦게 사용되는것!
        using=[]
        for device in current_using:
            # 이후에 사용되지 않는게 있다면 그게 타겟.
            if(device not in after_using):
                target=device
                break
            else:
                using.append(device)

        late_using=[]
        for device in after_using:
            if(device in using):
                late_using.append(device)

        #모두다 현재 사용되면 가장 늦게 사용되는걸 뺀다.
        if(target==0):
            target=late_using[-1]
        #뺄 대상 선정완료
        # print(i,current_using,after_using,late_using,target)
        plug_in[i]=1
        plug_in[target]=0
        ans+=1

print(ans)
