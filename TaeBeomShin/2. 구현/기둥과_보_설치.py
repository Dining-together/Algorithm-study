'''
구현은 어렵지 않으나 case분류를 꼼꼼히 해야함!!
'''
def build_check(frame,answers):
    x,y=frame[0],frame[1]
    if(frame[2]==0):
        return y==0 or [x-1,y,1] in answers or [x,y,1] in answers or [x,y-1,0] in answers
    else:
        return [x+1,y-1,0] in answers or [x,y-1,0] in answers or ([x-1,y,1] in answers and [x+1,y,1] in answers)


def can_remove_check(answers):
    check=True
    for answer in answers:
        if(build_check(answer,answers) is False):
            return False

    return check
    
def solution(n, build_frame):
    answer = []
    
    for frame in build_frame:
        current_frame,command=frame[:3],frame[3]
        
        if (command==1):
            if(build_check(current_frame,answer)):
                answer.append(current_frame)
        else:
            answer.remove(current_frame)
            if(can_remove_check(answer) is False):
                answer.append(current_frame)
        
    answer.sort()
    
    return answer