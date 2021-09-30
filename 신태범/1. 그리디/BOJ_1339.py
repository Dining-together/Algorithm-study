'''
N개의 단어가 주어졌을 때, 수의 합을 최대로.

1. 자릿수가 더 큰 수 이면 더 큰 숫자 배정.
-> 자릿수별로 가중치 두고, 가중치 더 큰수면 큰 숫자 배정.

내 풀이 개선: 가중치를 그대로 이용해서 바로 숫자를 곱해주는 식으로 개선가능.
'''

n=int(input())
weight_list={}
words=[]
for _ in range(n):
    word=input()
    words.append(word)
    #단어의 가중치 계산

    for i in range(len(word)):
        if(weight_list.get(word[i])!=None):
            weight_list[word[i]]+=10**(len(word)-i-1)
        else:
            weight_list[word[i]]=10**(len(word)-i-1)

# print(weight_list)
weight_list=sorted(weight_list.items(),key=lambda x : x[1],reverse=True)

alpha_number_dict={}

for i in range(len(weight_list)):
    alpha_number_dict[weight_list[i][0]]=9-i

# print(alpha_number_dict)

ans=0

for word in words:
    v=0
    for i in range(len(word)):
        v+=alpha_number_dict[word[i]]*(10**(len(word)-i-1))
    ans+=v

print(ans)