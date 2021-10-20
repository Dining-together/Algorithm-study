def solution(weights, head2head):
    new_heads,n=[],len(weights)
    
    for i in range(n):
        head=head2head[i]
        rate,w,l,m=0,head.count('W'),head.count('L'),0
        
        if(w+l!=0):
            rate=w/(w+l)
            
        for j in range(n):
            if(head[j]=='W' and weights[i]<weights[j]):
                m+=1
                
        new_heads.append([rate,m,weights[i],i+1])

    new_heads.sort(key= lambda h :(-h[0],-h[1],-h[2],h[3]))
    answer=[new_heads[i][3] for i in range(n)]
    return answer