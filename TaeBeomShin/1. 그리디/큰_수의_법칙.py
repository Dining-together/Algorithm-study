n,m,k=map(int,input().split())
num_list=sorted(list(map(int,input().split())))

first,second=num_list[n-1],num_list[n-2]

ans=m//(k+1)*(first*k+second)+m%(k+1)*first

print(ans)