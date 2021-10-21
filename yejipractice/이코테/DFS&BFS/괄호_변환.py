import sys
input = sys.stdin.readline

p = input().rstrip("\n")


def check_balance(pp):
    count = 0
    for i in range(len(pp)):
        if pp[i] == "(":
            count += 1
        else:
            count -= 1
        if count == 0:
            return i

# 올바른 괄호 문자열 구하는 법은 아래와 같이 count를 이용해서 하기.


def check_ok(pp):
    count = 0
    for i in range(len(pp)):
        if pp[i] == "(":
            count += 1
        else:
            if count == 0:
                return False
            count -= 1
    return True


def solution(p):
    answer = ""
    if p == "":
        return answer
    idx = check_balance(p)
    u = p[:idx+1]
    v = p[idx+1:]
    if check_ok(u):
        answer = u + solution(v)
    else:
        answer = "("+solution(v)+")"
        alist = list(u[1:-1])
        for i in range(len(alist)):
            if alist[i] == "(":
                alist[i] = ")"
            else:
                alist[i] = "("
        answer += "".join(alist)
    return answer


print(solution(p))
