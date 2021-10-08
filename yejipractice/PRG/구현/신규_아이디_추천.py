from collections import deque
new_id = input()


def solution(new_id):

    def check_alpha(id):
        id = list(id)
        for i in range(len(id)):
            if id[i].isdigit() or (id[i].isalpha() and id[i].islower()) or id[i] in ["-", "_", "."]:
                pass
            else:
                id[i] = ""
        return "".join(id)

    def check_jjum(id):
        queue = deque(list(id))
        isjjum = 0
        for i in range(len(id)):
            q = queue.popleft()
            if q != ".":
                isjjum = 0
                queue.append(q)
                continue
            else:
                if isjjum == 0:
                    isjjum = 1
                    queue.append(q)
        return "".join(queue)

    def check_frontback(id):
        id = list(id)
        if id[0] == ".":
            id[0] = ""
        if id[-1] == ".":
            id[-1] = ""
        return "".join(id)

    if new_id != "":
        new_id = new_id.lower()
        new_id = check_alpha(new_id)
        new_id = check_jjum(new_id)
        new_id = check_frontback(new_id)

    if new_id == "":
        new_id = "a"

    if len(new_id) >= 16:
        new_id = new_id[:15]
        new_id = check_frontback(new_id)

    if len(new_id) <= 2:
        while 1:
            if len(new_id) == 3:
                break
            new_id += new_id[-1]

    return new_id


print(solution(new_id))
# 배열 인덱스  a = [0, 1, 2, 3] a[:2] => [0, 1]
# 문자열 인덱스 a = "abcd" a[:2] => "ab"
