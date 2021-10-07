import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
build_frame = []
for i in range(m):
    build_frame.append(list(map(int, input().split())))


def solution(n, build_frame):
    answer = []

    def impossible(answer):
        for x, y, stuff in answer:
            if stuff == 0:  # 기둥
                if y == 0 or [x-1, y, 1] in answer or [x, y, 1] in answer or [x, y-1, 0] in answer:
                    continue
                return False
            elif stuff == 1:  # 보
                if [x, y-1, 0] in answer or [x+1, y-1, 0] in answer or ([x-1, y, 1] in answer and [x+1, y, 1] in answer):
                    continue
                return False
        return True

    for x, y, a, operate in build_frame:
        item = [x, y, a]
        if operate == 0:  # 삭제
            answer.remove(item)
            if not impossible(answer):
                answer.append(item)
        if operate == 1:
            answer.append(item)
            if not impossible(answer):
                answer.remove(item)
    return sorted(answer)

# 불가능한 경우인지 확인하고 나서 롤백

# 이전에는 따로 불가능한 경우인지 체크하려고 해서 에러
# 처음부터 기둥과 보를 나눠서 해서 에러
