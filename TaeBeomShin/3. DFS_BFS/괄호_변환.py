def is_right(s):
    a=[]
    for c in s:
        if(len(a)==0):
            a.append(c)
            continue
        else:
            if(c==")" and a[len(a)-1]=="("):
                a.pop()
            else:
                a.append(c)
    return len(a)==0

def reverse_curse(p):
    new_p=[]
    for c in p:
        if(c=="("):
            new_p.append(")")
        else:
            new_p.append("(")
    new_p=''.join(new_p)
    return new_p

def dfs(munja):
    if(len(munja)==0):
        return munja
    u,v="",""
    for i in range(1,len(munja)+1):
        s=munja[:i]
        if(s.count("(")==s.count(")")):
            u,v=s,munja[i:]
            break
    if(is_right(u)):
        v=dfs(v)
        return u+v
    else:
        v=dfs(v)
        u="("+v+")"+reverse_curse(u[1:len(u)-1])
        return u
    
def solution(p):
    answer = dfs(p)
    return answer