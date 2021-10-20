n=input()
l,r=0,0
for i in range(len(n)//2):
    l+=int(n[i])
    r+=int(n[len(n)//2+i])
if(l==r):print("LUCKY")
else:print("READY")