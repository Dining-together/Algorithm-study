import queue

n,q,s=int(input()),queue.PriorityQueue(),0
for _ in range(n): q.put(int(input()))

while(q.qsize()>1):
    f,s=q.get(),q.get()
    s+=f+s
    q.put(f+s)
    
print(s)
