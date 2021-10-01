n=int(input())
scores=[int(input()) for _ in range(n)]
scores,ans=scores[::-1],0

for i in range(n-1):
    if(scores[i]<=scores[i+1]):
        ans+=scores[i+1]-scores[i]+1
        scores[i+1]=scores[i]-1

print(ans)