'''
3배 곱한 공간을 순회하는 방식

개선 -> deepcopy 하는식 말고 더했다가 빼는식으로 하면 복사시간이 사라질듯
'''

import copy

def rotate_90(array):
    b = list(map(list, zip(*reversed([*array]))))
    return b

def is_in_range(x,y,n):
    return (x>=n and x<2*n and y>=n and y<2*n)

def solution(key, lock):
    answer = False
    m,n=len(key),len(lock)
    lock_3times=[[0 for i in range(3*n)] for j in range(3*n)]
    
    for i in range(n):
        for j in range(n):
            lock_3times[n+i][n+j]=lock[i][j]
    
    for d in range(4):
        if(d>0):
            key=rotate_90(key)
        for r in range(2*n):
            for c in range(2*n):
                flag=False
                temp_array=copy.deepcopy(lock_3times)
                
                for i in range(m):
                    for j in range(m):
                        cx,cy=r+i,c+j
                        if(is_in_range(cx,cy,n)):
                            if(lock_3times[cx][cy]+key[i][j]==1):
                                temp_array[cx][cy]=1
                            else:
                                flag=True
                                break
                    if(flag):
                        break
                        
                if(flag==False and sum(sum(temp_array,[]))==n*n):
                    answer=True
                    return answer
                                
    return answer