
def check(result):
    for x, y, a in result:
        if a==0: # 기둥 설치
            if y==0 or [x-1, y, 1] in result or [x,y,1] in result or [x,y-1,0] in result:
                continue
            return False
        elif a==1: # 보 설치
            if [x+1, y-1, 0] in result or [x,y-1,0] in result or ([x-1,y,1] in result and [x+1,y,1] in result):
                continue
            return False
    return True



def solution(n, build_frame):
    result = []

    for frame in build_frame:
        x,y,b,c = frame
        if b == 0: # 삭제
            result.remove([x,y,c])
            if check(result) is False:
                result.append([x,y,c])
        elif b ==1:
            result.append([x,y,c])
            if check(result) is False:
                result.remove([x,y,c])
    result.sort()
    return result


