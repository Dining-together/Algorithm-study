s = input()

def solution(s):
    answer = 0
    return answer

result = len(s)

for i in range(1, len(s) //2 +1):
    cut = s[0:i]
    string=""
    count = 1
    for j in range(i, len(s)+1, i):
        if(cut == s[j:j+i]):
            count+=1
        else:
            if count!=1:
                string += str(count)+cut
                cut = s[j:j+i]
                count = 1
            else:
                string += cut
                cut = s[j:j+i]
    if count!=1:
        string += str(count)+cut
    else:
        string += cut
    result = min(len(string), result)

print(result)
