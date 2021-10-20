n=int(input())
student=[]
for _ in range(n):
    name,k,e,m=input().split()
    k,e,m=int(k),int(e),int(m)
    student.append([name,k,e,m])
student.sort(key=lambda k:(-k[1],k[2],-k[3],k[0]))
for s in student:
    print(s[0])