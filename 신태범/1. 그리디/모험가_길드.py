n=int(input())
guild_list=sorted(list(map(int,input().split())))

i,ans=0,0

while(i<len(guild_list)):
    current_fury=guild_list[i]
    
    for j in range(i,i+current_fury):
        if(guild_list[j]>current_fury):
            current_fury=guild_list[j]
    
    i+=current_fury
    if(i<len(guild_list)):
        ans+=1

print(ans)