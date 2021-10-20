def solution(N, stages):
    l=[[0,0] for _ in range(N+2)]
    for s in stages:
        l[s][0]+=1
        for i in range(1,s+1):
            l[i][1]+=1
    
    s={}
    for i in range(1,N+1):
        s[i]=0
        if(l[i][1]>0):
            s[i]=l[i][0]/l[i][1]
    
    s=sorted(s.items(),key=lambda l:-l[1])

    return [i[0] for i in s]