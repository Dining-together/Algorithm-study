def solution(s):
    answer = len(s)
    
    for i in range(1,len(s)//2+1):
        length,before,current_idx,current_count=i,s[:i],i,1
        current_string=""
        while(True):
            if(current_idx>=len(s)):
                if(current_count>=2):
                    current_string+=str(current_count)+before
                else:
                    current_string+=s[current_idx-i:]
                break
            current=s[current_idx:current_idx+i]
            if(current==before):
                current_count+=1
            else:
                if(current_count==1):
                    current_string+=before
                else:
                    current_string+=str(current_count)+before
                current_count=1
            before=current
            current_idx+=i
        answer=min(len(current_string),answer)
    return answer